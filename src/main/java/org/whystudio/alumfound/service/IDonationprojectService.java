package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Donationproject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 捐赠项目信息 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IDonationprojectService extends IService<Donationproject> {

    Response donationprojectList();
}
