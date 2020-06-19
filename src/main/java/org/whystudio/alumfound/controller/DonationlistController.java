package org.whystudio.alumfound.controller;


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
@RestController
@RequestMapping("/alumfound/donationlist")
public class DonationlistController extends BaseController{

    @GetMapping("")
    @ApiOperation(value="获取捐赠列表的列表信息", notes = "捐赠列表是属于公开信息里面的内容，不是列表，就是一张表格（以图片形式显示)")
    public Response donationlistList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size){
        return donationlistService.donationlistList(currentPage, size);
    }

    @GetMapping("{id}")
    public Response oneDonationlist(@PathVariable Long id){
        return donationlistService.oneDonationlist(id);
    }

}

