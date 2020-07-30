package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 普通新闻 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "普通新闻模块")
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "全部普通新闻列表-分页查询", notes = "无参默认第一页五条记录")
    public Response newsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return newsService.newsList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询全部普通新闻信息", notes = "传id")
    public Response selectNew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(newsService.selectNew(id));
    }


    @GetMapping("/alumni")
    @ApiOperation(value = "校友会普通新闻列表-分页查询")
    public Response alumniNewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return ResponseUtil.autoJudgeByData(newsService.selectAlumniNewsList(currentPage,size));
    }

    @GetMapping("/alumni/{id}")
    @ApiOperation(value = "根据ID查询校友会普通新闻",notes = "预留接口  \n 请确保传入id为校友会新闻id  \n该接口返回的新闻数据中前一条和后一条新闻均为校友会新闻")
    public Response selectAlumniNew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(newsService.selectAlumniNew(id));
    }

    @GetMapping("/foundation")
    @ApiOperation(value = "基金会普通新闻列表-分页查询")
    public Response foundationNewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return ResponseUtil.autoJudgeByData(newsService.selectFoundationNewsList(currentPage,size));
    }

    @GetMapping("/foundation/{id}")
    @ApiOperation(value = "根据ID查询基金会普通新闻",notes = "预留接口  \n 请确保传入id为基金会新闻id  \n该接口返回的新闻数据中前一条和后一条新闻均为基本会新闻")
    public Response selectFoundationNew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(newsService.selectFoundationNew(id));
    }


    //
    // @GetMapping("/{id}")
    // @ApiOperation(value = "根据ID查询某条新闻信息", notes = "传id id通过list获取")
    // public Response oneNews(@PathVariable Long id) {
    //     return newsService.oneNews(id);
    // }

    // @GetMapping("/list")
    // @ApiOperation(value = "分页获取新闻信息", notes = "当前页若未上传则默认为首页")
    // public Response list(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
    //     return ResponseUtil.autoJudgeByData(newsService.newsForPage(page));
    // }

    // @GetMapping("/detail")
    // @ApiOperation(value = "获取指定新闻详情")
    // public Response detail(@RequestParam(value = "id") Long id) {
    //     return ResponseUtil.autoJudgeByData(newsService.getNews(id));
    // }
}

