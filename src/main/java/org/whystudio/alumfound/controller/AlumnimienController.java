package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.IAlumnimienService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 校友风采 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/alumnimien")
public class AlumnimienController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "校友风采列表", notes = "不传参数默认第一页五条记录")
    public Response alumnimienList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return alumnimienService.alumnimienList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条校友风采信息", notes = "传id id通过list获取")
    public Response oneAlumnimien(@PathVariable Long id) {
        return alumnimienService.oneAlumnimien(id);
    }

    @Resource
    IAlumnimienService alumnimienService;

    @GetMapping("/detail")
    @ApiOperation(value = "获取指定校友风采内容")
    public Response get(@RequestParam(value = "id") Long id) {
        return ResponseUtil.autoJudgeByData(alumnimienService.getAlumnimien(id));
    }

    @GetMapping("list")
    @ApiOperation(value = "获取校友分页数据")
    public Response getList(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
        return ResponseUtil.autoJudgeByData(alumnimienService.getAlumnimienList(page));
    }
}

