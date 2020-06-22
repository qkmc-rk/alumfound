package org.whystudio.alumfound.controller;


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
@RestController
@RequestMapping("/alumfound/donationproject")
public class DonationprojectController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "获取捐款项目信息")
    public Response donationprojectList() {
        return donationprojectService.donationprojectList();
    }

}

