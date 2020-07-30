package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 捐赠信息-校友捐赠后会记录在数据库 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "捐赠信息模块")
@RestController
@RequestMapping("/donationinfo")
public class DonationinfoController extends BaseController {


    @GetMapping("")
    @ApiOperation(value = "捐赠信息列表-分页查询", notes = "不传参数默认第一页五条记录")
    public Response donationList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return ResponseUtil.autoJudgeByData(donationinfoService.donationinfoList(currentPage, size));
    }


    // @GetMapping(value = "")
    // @ApiOperation(value = "捐赠信息列表-分页查询", notes = "按时间降序,筛选条件仅支持equal，根据传参数据过滤。页号未上传默认为首页")
    // public Response donationList(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
    //                              Donationinfo donationinfo) {
    //
    //     Map<String, Object> map = BeanUtils.beanToMap(donationinfo);
    //     return ResponseUtil.autoJudgeByData(donationinfoService.getDonations(page, map));
    // }

}

