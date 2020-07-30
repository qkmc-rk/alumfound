package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 捐赠项目信息 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "捐赠项目模块")
@RestController
@RequestMapping("/donationproject")
public class DonationprojectController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "捐赠项目列表")
    public Response donationprojectList() {
        return donationprojectService.donationprojectList();
    }

}

