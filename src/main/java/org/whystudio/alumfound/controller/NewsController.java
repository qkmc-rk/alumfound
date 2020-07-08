package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.INewsService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 普通新闻 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/news")
public class NewsController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "新闻列表", notes = "不传参数默认第一页五条记录")
    public Response newsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return newsService.newsList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条新闻信息", notes = "传id id通过list获取")
    public Response oneNews(@PathVariable Long id) {
        return newsService.oneNews(id);
    }

    @Resource
    INewsService newsService;

    @GetMapping("/list")
    @ApiOperation(value = "分页获取新闻信息", notes = "当前页若未上传则默认为首页")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return ResponseUtil.autoJudgeByData(newsService.newsForPage(page));
    }
    @GetMapping("/detail")
    @ApiOperation(value = "获取指定新闻详情")
    public Response detail(@RequestParam(value = "id") Long id) {
        return ResponseUtil.autoJudgeByData(newsService.getNews(id));
    }
}

