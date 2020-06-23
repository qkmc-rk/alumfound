package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Alumnimien;
import org.whystudio.alumfound.mapper.AlumnimienMapper;
import org.whystudio.alumfound.service.IAlumnimienService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 校友风采 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class AlumnimienServiceImpl extends ServiceImpl<AlumnimienMapper, Alumnimien> implements IAlumnimienService {
    @Override
    public IPage<Alumnimien> getAlumnimienList(Integer page) {
        Page<Alumnimien> alumnimienPage = new Page<>();
        alumnimienPage.setSize(Constant.DEFAULT.getSIZE());
        return getBaseMapper().selectPage(alumnimienPage, null);
    }

    @Override
    public Alumnimien getAlumnimien(Long id) {
        return getBaseMapper().selectById(id);
    }
}
