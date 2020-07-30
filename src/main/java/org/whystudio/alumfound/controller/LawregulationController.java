package org.whystudio.alumfound.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 政策法规 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Api(tags = "规章制度-政策法规模块")
@RestController
@RequestMapping("/lawregulation")
public class LawregulationController extends BaseController {

    @GetMapping("")
    @ApiOperation(value = "政策法规列表-分页查询", notes = "无参默认第一页五条记录")
    public Response lawregulationList(@RequestParam(required = false) Integer currentPage, @RequestParam(required = false) Integer size) {
        return lawregulationService.lawregulationList(currentPage, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询政策法规信息", notes = "传id id通过list获取")
    public Response oneLawRegulation(@PathVariable Long id) {
        return ResponseUtil.autoJudgeByData(lawregulationService.selectLawRegulation(id));
    }


    // @GetMapping("/{id}")
    // @ApiOperation(value = "根据ID查询某条政策法规信息", notes = "传id id通过list获取")
    // public Response oneLawregulation(@PathVariable Long id) {
    //     return lawregulationService.oneLawregulation(id);
    // }

    //
    // @GetMapping(value = "/list")
    // @ApiOperation(value= "分页获取政策法规数据", notes = "默认分页号为1")
    // public Response list(@RequestParam(value = "page", required = false, defaultValue = "1")Integer page){
    //     return ResponseUtil.autoJudgeByData(lawregulationService.page(page));
    // }

}

