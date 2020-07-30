package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Banner;
import org.whystudio.alumfound.mapper.BannerMapper;
import org.whystudio.alumfound.service.IBannerService;

import java.util.List;

/**
 * <p>
 * 主页banner 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {


    @Override
    public List<Banner> bannerList() {
        return getBaseMapper().selectList(
                Wrappers.<Banner>lambdaQuery()
                        .orderByDesc(Banner::getModified)
                        .last("limit 5")
        );
    }
}
