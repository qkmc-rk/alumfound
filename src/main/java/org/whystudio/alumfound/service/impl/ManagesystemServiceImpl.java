package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Managesystem;
import org.whystudio.alumfound.mapper.ManagesystemMapper;
import org.whystudio.alumfound.service.IManagesystemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理制度 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class ManagesystemServiceImpl extends ServiceImpl<ManagesystemMapper, Managesystem> implements IManagesystemService {

    @Override
    public IPage<Managesystem> page(Integer page) {
        Page<Managesystem> managesystemPage = new Page<>();
        managesystemPage.setSize(Constant.DEFAULT.getSIZE());
        return getBaseMapper().selectPage(managesystemPage, null);
    }

    @Override
    public Managesystem getById(Long id) {
        return getBaseMapper().selectById(id);
    }
}
