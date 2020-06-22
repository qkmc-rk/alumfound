package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 政策法规 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/lawregulation")
public class LawregulationController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "政策法规列表", notes = "不传参数默认第一页五条记录")
    public Response lawregulationList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return lawregulationService.lawregulationList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条政策法规信息", notes = "传id id通过list获取")
    public Response oneLawregulation(@PathVariable Long id) {
        return lawregulationService.oneLawregulation(id);
    }

}

