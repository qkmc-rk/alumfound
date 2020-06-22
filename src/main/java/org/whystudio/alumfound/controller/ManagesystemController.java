package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 管理制度 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/managesystem")
public class ManagesystemController extends  BaseController{

    @GetMapping("")
    @ApiOperation(value = "管理制度列表", notes = "不传参数默认第一页五条记录")
    public Response managesystemList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return managesystemService.managesystemList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询某条政策法规信息", notes = "传id id通过list获取")
    public Response oneManagesystem(@PathVariable Long id) {
        return managesystemService.oneManagesystem(id);
    }

}

