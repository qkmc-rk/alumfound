package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Lawregulation;
import org.whystudio.alumfound.mapper.LawregulationMapper;
import org.whystudio.alumfound.service.ILawregulationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 政策法规 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class LawregulationServiceImpl extends ServiceImpl<LawregulationMapper, Lawregulation> implements ILawregulationService {

    @Override
    public IPage<Lawregulation> page(Integer page) {
        Page<Lawregulation> lawregulationPage = new Page<>();
        lawregulationPage.setSize(Constant.DEFAULT.getSIZE());
        return getBaseMapper().selectPage(lawregulationPage, null);
    }
}
