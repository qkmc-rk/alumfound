package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.IPicnewsService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 图片新闻 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/picnews")
public class PicnewsController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "图片新闻列表", notes = "不传参数默认第一页五条记录")
    public Response picnewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return picnewsService.picnewsList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条图片新闻信息", notes = "传id id通过list获取")
    public Response onePicnews(@PathVariable Long id) {
        return picnewsService.onePicnews(id);
    }
    @Resource
    IPicnewsService picnewsService;

    @GetMapping("/detail")
    @ApiOperation(value = "获取详细的图片新闻数据")
    public Response detail(@RequestParam(value = "id") Long id) {
        return ResponseUtil.autoJudgeByData(picnewsService.picNews(id));
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取图片新闻的分页数据", notes = "默认页号为1")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        return ResponseUtil.autoJudgeByData(picnewsService.page(page));
    }
}

