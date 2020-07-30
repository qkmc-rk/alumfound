package org.whystudio.alumfound.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.entity.Statistics;
import org.whystudio.alumfound.service.IStatisticsService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 数据统计
 * @author: CoderM
 * @date: 2020/7/28 19:02
 */
@Api(tags = "数据统计模块")
@RestController
@RequestMapping("/statistics")
public class StatisticsController extends BaseController {

    @Autowired
    IStatisticsService statisticsService;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/info/{strDate}")
    @ApiOperation(value = "获取访问量",notes = "日期格式为:yyyy-MM-dd")
    public Response getVisitNumber(@RequestParam(value = "strDate",defaultValue = "2020-07-29") @PathVariable String strDate) {
        Date date;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseUtil.failWithoutData("日期转换错误");
        }

        Statistics statistics = statisticsService.getVisitData(date);
        return ResponseUtil.autoJudgeByData(statistics);
    }

    @PostMapping("/visit/{strDate}")
    @ApiOperation(value = "增加访问量",notes = "日期格式为:yyyy-MM-dd,在访问网站时调用该请求")
    public Response visit(@RequestParam(value = "strDate",defaultValue = "2020-07-29") @PathVariable String strDate) {
        Date date;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseUtil.failWithoutData("日期转换错误");
        }
        Statistics statistics = new Statistics(null, 1L, 1L, date);
        if (statisticsService.addVisitNumber(statistics)) {
            return ResponseUtil.successWithoutData("增加访问量成功");
        }
        return ResponseUtil.failWithoutData("增加访问量失败");

    }
}
