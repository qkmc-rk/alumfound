package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开 - 年度报告 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/yearlyreport")
public class YearlyreportController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "获取年度报告",notes = "分页，默认第一页，五条数据")
    public Response yearlyreportList(Integer currentPage, Integer size){

        return yearlyreportService.yearlyreportList(currentPage, size);
    }

    @GetMapping("{id}")
    public Response oneYearlyreport(@PathVariable Long id) {
        return yearlyreportService.oneYearlyreport(id);
    }

}

