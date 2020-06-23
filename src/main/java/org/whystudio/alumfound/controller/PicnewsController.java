package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
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
public class PicnewsController {

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

