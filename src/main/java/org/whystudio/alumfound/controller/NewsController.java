package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
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
public class NewsController {

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

