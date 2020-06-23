package org.whystudio.alumfound.controller;


import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.whystudio.alumfound.entity.Donationinfo;
import org.whystudio.alumfound.service.IDonationinfoService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 捐赠信息-校友捐赠后会记录在数据库 前端控制器
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/alumfound/donationinfo")
public class DonationinfoController {

    @Resource
    IDonationinfoService donationinfoService;

    @GetMapping(value = "")
    @ApiOperation(value = "分页获取捐赠数据, 按时间降序", notes = "筛选条件仅支持equal，根据传参数据过滤。页号未上传默认为首页")
    public Response donationList(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                 Donationinfo donationinfo) {

        // todo 运行时无法解析，缺少net.sf.cglib.bens.BeanMap,是否自动转化驼峰？
        Map<String, Object> map = BeanUtils.beanToMap(donationinfo);
        return ResponseUtil.autoJudgeByData(donationinfoService.getDonations(page, map));

    }


}

