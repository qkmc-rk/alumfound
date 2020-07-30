package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开-捐赠名单 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "信息公开-捐赠名单模块")
@RestController
@RequestMapping("/donationlist")
public class DonationlistController extends BaseController{

    @GetMapping("")
    @ApiOperation(value="捐赠信息列表-分页查询", notes = "捐赠列表是属于公开信息里面的内容，不是列表，就是一张表格（以图片形式显示)")
    public Response donationlistList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return donationlistService.donationlistList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询捐赠信息")
    public Response oneDonationlist(@PathVariable Long id){
        return donationlistService.oneDonationlist(id);
    }

}

