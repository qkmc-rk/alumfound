package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Donationlist;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开-捐赠名单 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IDonationlistService extends IService<Donationlist> {

    Response donationlistList(Integer currentPage, Integer size);

    Response oneDonationlist(Long id);
}
