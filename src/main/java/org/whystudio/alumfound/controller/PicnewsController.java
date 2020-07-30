package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 图片新闻 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "图片新闻模块")
@RestController
@RequestMapping("/picnews")
public class PicnewsController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "全部图片新闻列表-分页查询", notes = "不传参数默认第一页五条记录")
    public Response picnewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return picnewsService.picnewsList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询全部图片新闻信息", notes = "传id id通过list获取")
    public Response selectPicnew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(picnewsService.selectPicnew(id));
    }

    @GetMapping("/alumni/{id}")
    @ApiOperation(value = "根据ID查询校友会图片新闻",notes = "预留接口  \n 请确保传入id为校友会新闻id  \n该接口返回的新闻数据中前一条和后一条新闻均为校友会新闻")
    public Response selectAlumniNew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(picnewsService.selectAlumniNew(id));
    }

    @GetMapping("/alumni")
    @ApiOperation(value = "校友会图片新闻列表-分页查询")
    public Response alumniPicnewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return ResponseUtil.autoJudgeByData(picnewsService.selectAlumniPicnewsList(currentPage,size));
    }

    @GetMapping("/foundation/{id}")
    @ApiOperation(value = "根据ID查询基金会图片新闻",notes = "预留接口  \n 请确保传入id为基金会新闻id  \n该接口返回的新闻数据中前一条和后一条新闻均为基本会新闻")
    public Response selectFoundationNew(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(picnewsService.selectFoundationNew(id));
    }

    @GetMapping("/foundation")
    @ApiOperation(value = "基金会图片新闻列表-分页查询")
    public Response foundationPicnewsList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return ResponseUtil.autoJudgeByData(picnewsService.selectFoundationPicnewsList(currentPage,size));
    }

    // @Resource
    // IPicnewsService picnewsService;
    //
    // @GetMapping("/detail")
    // @ApiOperation(value = "获取详细的图片新闻数据")
    // public Response detail(@RequestParam(value = "id") Long id) {
    //     return ResponseUtil.autoJudgeByData(picnewsService.picNews(id));
    // }
    //
    // @GetMapping("/list")
    // @ApiOperation(value = "获取图片新闻的分页数据", notes = "默认页号为1")
    // public Response list(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
    //
    //     return ResponseUtil.autoJudgeByData(picnewsService.page(page));
    // }
}

