package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.constant.SQLResult;
import org.whystudio.alumfound.entity.Alumniinfo;
import org.whystudio.alumfound.service.IAlumniinfoService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;

/**
 * <p>
 * 前端采集并登记校友信息 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "校友信息模块")
@RestController
@RequestMapping("/alumniinfo")
public class AlumniinfoController extends BaseController {

    @Resource
    IAlumniinfoService iAlumniinfoService;

    @PostMapping("")
    @ApiOperation(value = "校友信息数据插入接口")
    public Response saveInfo(Alumniinfo alumniinfo) {
        Integer result = iAlumniinfoService.saveInfo(alumniinfo);
        if (result < 0) {
            return ResponseUtil.failWithoutData(SQLResult.errorMsg(result));
        }else{
            return ResponseUtil.successWithoutData("success");
        }
    }


}

