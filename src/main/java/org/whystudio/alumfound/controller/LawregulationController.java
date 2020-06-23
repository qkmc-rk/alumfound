package org.whystudio.alumfound.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.service.ILawregulationService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 政策法规 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/lawregulation")
public class LawregulationController {

    @Resource
    ILawregulationService lawregulationService;

    @GetMapping(value = "/list")
    @ApiOperation(value= "分页获取政策法规数据", notes = "默认分页号为1")
    public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
        return ResponseUtil.autoJudgeByData(lawregulationService.page(page));
    }

}

