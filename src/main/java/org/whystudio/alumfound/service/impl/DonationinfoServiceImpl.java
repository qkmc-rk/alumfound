package org.whystudio.alumfound.service.impl;

import org.whystudio.alumfound.entity.Donationinfo;
import org.whystudio.alumfound.mapper.DonationinfoMapper;
import org.whystudio.alumfound.service.IDonationinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 捐赠信息-校友捐赠后会记录在数据库 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class DonationinfoServiceImpl extends ServiceImpl<DonationinfoMapper, Donationinfo> implements IDonationinfoService {

}
