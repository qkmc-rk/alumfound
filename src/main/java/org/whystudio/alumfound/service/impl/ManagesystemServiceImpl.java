package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Managesystem;
import org.whystudio.alumfound.mapper.ManagesystemMapper;
import org.whystudio.alumfound.service.IManagesystemService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

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
    public Response managesystemList(Integer currentPage, Integer size) {
        IPage<Managesystem> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        IPage<Managesystem> managesystemPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), null);
        return ResponseUtil.autoJudgeByData(managesystemPage);
    }



    @Override
    public Managesystem selectManageSystem(Long id) {

        Managesystem managesystem = getBaseMapper().selectById(id);


        if (null == managesystem) {
            return null;
        }

        Managesystem last = getBaseMapper().selectOne(
                Wrappers.<Managesystem>lambdaQuery()
                        .gt(Managesystem::getModified, managesystem.getModified())
                        .orderByAsc(Managesystem::getModified)
                        .last("limit 1")
        );

        Managesystem next = getBaseMapper().selectOne(

                Wrappers.<Managesystem>lambdaQuery()
                        .lt(Managesystem::getModified, managesystem.getModified())
                        .orderByDesc(Managesystem::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            managesystem.setLastId(last.getId());
            managesystem.setLastTitle(last.getTitle());
        }

        if (null != next) {
            managesystem.setNextId(next.getId());
            managesystem.setNextTitle(next.getTitle());
        }

        return managesystem;
    }

    // @Override
    // public Response oneManagesystem(Long id) {
    //     if (id < 0L) {
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     Managesystem managesystem = getBaseMapper().selectById(id);
    //     return ResponseUtil.autoJudgeByData(managesystem);
    // }

    // @Override
    // public IPage<Managesystem> page(Integer page) {
    //     Page<Managesystem> managesystemPage = new Page<>();
    //     managesystemPage.setSize(Constant.DEFAULT.getSIZE());
    //     return getBaseMapper().selectPage(managesystemPage, null);
    // }

    // @Override
    // public Managesystem getById(Long id) {
    //     return getBaseMapper().selectById(id);
    // }
}
