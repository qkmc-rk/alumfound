package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 受益人信息公示 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "信息公开-受益方公示模块")
@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController extends BaseController{

    @GetMapping("")
    @ApiOperation(value = "查询公开信息-受益人公开信息", notes = "不传参数默认第一页五条记录")
    public Response beneficiaryList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return beneficiaryService.beneficiaryList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询受益人公开信息", notes = "传id id通过list获取")
    public Response selectBeneficiary(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(beneficiaryService.selectBeneficiary(id));
    }

}

