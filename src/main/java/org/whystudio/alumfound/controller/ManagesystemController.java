package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.IManagesystemService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 管理制度 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/managesystem")
public class ManagesystemController extends  BaseController{

    @GetMapping("")
    @ApiOperation(value = "管理制度列表", notes = "不传参数默认第一页五条记录")
    public Response managesystemList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return managesystemService.managesystemList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条政策法规信息", notes = "传id id通过list获取")
    public Response oneManagesystem(@PathVariable Long id) {
        return managesystemService.oneManagesystem(id);
    }

    @Resource
    IManagesystemService managesystemService;

    @GetMapping("/detail")
    @ApiOperation(value = "获取管理信息详细数据")
    public Response detail(@RequestParam(value = "id")Long id){
        return ResponseUtil.autoJudgeByData(managesystemService.getById(id));
    }

    @GetMapping(value = "/list")
    @ApiOperation(value="获取管理信息分页数据", notes = "页号默认为1")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
        return ResponseUtil.autoJudgeByData(managesystemService.page(page));
    }

}

