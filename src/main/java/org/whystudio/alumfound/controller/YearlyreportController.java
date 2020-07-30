package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
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
@Api(tags="信息公开-年度报告模块")
@RestController
@RequestMapping("/yearlyreport")
public class YearlyreportController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "年度报告-分页查询",notes = "默认第一页，五条数据")
    public Response yearlyreportList(Integer currentPage, Integer size){

        return yearlyreportService.yearlyreportList(currentPage, size);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询年度报告")
    public Response oneYearlyreport(@PathVariable Long id) {
        return yearlyreportService.oneYearlyreport(id);
    }

}

