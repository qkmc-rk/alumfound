package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Alumnimien;
import org.whystudio.alumfound.entity.Lawregulation;
import org.whystudio.alumfound.mapper.AlumnimienMapper;
import org.whystudio.alumfound.service.IAlumnimienService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

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
    public Response alumnimienList(Integer currentPage, Integer size) {
        IPage<Alumnimien> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        IPage<Alumnimien> alumnimienPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), null);
        return ResponseUtil.autoJudgeByData(alumnimienPage);
    }

    @Override
    public Response oneAlumnimien(Long id) {
        if (id < 0L){
            return ResponseUtil.failWithoutData("error id:" + id);
        }
        Alumnimien alumnimien = getBaseMapper().selectById(id);
        return ResponseUtil.autoJudgeByData(alumnimien);
    }
}
