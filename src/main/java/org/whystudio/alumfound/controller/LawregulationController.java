package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.ILawregulationService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

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

    @Resource
    ILawregulationService lawregulationService;

    @GetMapping(value = "/list")
    @ApiOperation(value= "分页获取政策法规数据", notes = "默认分页号为1")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
        return ResponseUtil.autoJudgeByData(lawregulationService.page(page));
    }

}

