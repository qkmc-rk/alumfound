package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Donationinfo;
import org.whystudio.alumfound.mapper.DonationinfoMapper;
import org.whystudio.alumfound.service.IDonationinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    /**
     *
     * 根据所传过滤条件查找分页数据。
     *
     * @param currentPage 当前所请求数据页数
     * @param map   由上传的数据bean转化成的map<property, value>
     * @return
     */
    @Override
    public IPage<Donationinfo> getDonations(Integer currentPage, Map<String, Object> map) {
        Page<Donationinfo> donationinfoPage = new Page<>();
        donationinfoPage.setSize(Constant.DEFAULT.getSIZE());
        donationinfoPage.addOrder(OrderItem.desc("created"));
        return getBaseMapper().selectPage(donationinfoPage, null);

    }
}
