package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;

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

}

