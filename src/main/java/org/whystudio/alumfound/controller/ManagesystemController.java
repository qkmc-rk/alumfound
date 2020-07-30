package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 管理制度 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "规章制度 -管理制度模块")
@RestController
@RequestMapping("/managesystem")
public class ManagesystemController extends BaseController {


    @GetMapping("")
    @ApiOperation(value = "管理制度列表-分页查询", notes = "不传参数默认第一页五条记录")
    public Response managesystemList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return managesystemService.managesystemList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询管理制度信息", notes = "传入id")
    public Response selectManageSystem(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(managesystemService.selectManageSystem(id));
    }

    // @GetMapping("/{id}")
    // @ApiOperation(value = "根据ID查询某条政策法规信息", notes = "传入id")
    // public Response oneManagesystem(@PathVariable Long id) {
    //     return managesystemService.oneManagesystem(id);
    // }


    // @GetMapping("/detail")
    // @ApiOperation(value = "获取管理信息详细数据")
    // public Response detail(@RequestParam(value = "id")Long id){
    //     return ResponseUtil.autoJudgeByData(managesystemService.getById(id));
    // }

    // @GetMapping(value = "/list")
    // @ApiOperation(value="获取管理信息分页数据", notes = "页号默认为1")
    // public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
    //     return ResponseUtil.autoJudgeByData(managesystemService.page(page));
    // }

}

