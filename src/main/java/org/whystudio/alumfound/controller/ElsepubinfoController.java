package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 公开信息- 其它公示 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "信息公开-其他信息模块")
@RestController
@RequestMapping("/elsepubinfo")
public class ElsepubinfoController extends BaseController {

    @GetMapping("")
    @ApiOperation(value = "其它信息列表-分页查询", notes = "不传参数默认第一页五条记录")
    public Response elsePubInfoList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return elsepubinfoService.elsePubInfoList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询其它公示信息", notes = "传id id通过list获取")
    public Response oneElsePubInfo(@PathVariable Long id) {

        return ResponseUtil.autoJudgeByData(elsepubinfoService.selectElsePubInfo(id));

    }

    // @GetMapping("/{id}")
    // @ApiOperation(value = "根据ID查询其它公示信息", notes = "传id id通过list获取")
    // public Response oneElsePubInfo(@PathVariable Long id) {
    //     return elsepubinfoService.oneElsePubInfo(id);
    // }


}

