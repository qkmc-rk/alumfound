package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 主页banner 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "轮播图模块")
@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "首页轮播图")
    public Response bannerList() {

        return ResponseUtil.autoJudgeByData(bannerService.bannerList());

    }

}

