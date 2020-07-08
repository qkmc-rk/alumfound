package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Donationinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 捐赠信息-校友捐赠后会记录在数据库 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IDonationinfoService extends IService<Donationinfo> {

    IPage<Donationinfo> getDonations(Integer currentPage, Map<String, Object> map);

}
