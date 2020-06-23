package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.IManagesystemService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

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
public class ManagesystemController {

    @Resource
    IManagesystemService managesystemService;

    @GetMapping("/detail")
    @ApiOperation(value = "获取管理信息详细数据")
    public Response detail(@RequestParam(value = "id")Long id){
        return ResponseUtil.autoJudgeByData(managesystemService.getById(id));
    }

    @GetMapping(value = "/list")
    @ApiOperation(value="获取管理信息分页数据", notes = "页号默认为1")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
        return ResponseUtil.autoJudgeByData(managesystemService.page(page));
    }

}

