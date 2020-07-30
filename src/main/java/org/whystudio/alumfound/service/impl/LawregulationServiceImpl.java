package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Lawregulation;
import org.whystudio.alumfound.mapper.LawregulationMapper;
import org.whystudio.alumfound.service.ILawregulationService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

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
    public Response lawregulationList(Integer currentPage, Integer size) {
        IPage<Lawregulation> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        IPage<Lawregulation> lawregulationPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), null);
        return ResponseUtil.autoJudgeByData(lawregulationPage);

    }

    // @Override
    // public Response oneLawregulation(Long id) {
    //     if (id < 0L) {
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     Lawregulation lawregulation = getBaseMapper().selectById(id);
    //     return ResponseUtil.autoJudgeByData(lawregulation);
    // }

    @Override
    public Lawregulation selectLawRegulation(Long id) {
        Lawregulation lawregulation = getBaseMapper().selectById(id);

        if (null == lawregulation) {
            return null;
        }

        Lawregulation last = getBaseMapper().selectOne(
                Wrappers.<Lawregulation>lambdaQuery()
                        .gt(Lawregulation::getModified, lawregulation.getModified())
                        .orderByAsc(Lawregulation::getModified)
                        .last("limit 1")
        );

        Lawregulation next = getBaseMapper().selectOne(

                Wrappers.<Lawregulation>lambdaQuery()
                        .lt(Lawregulation::getModified, lawregulation.getModified())
                        .orderByDesc(Lawregulation::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            lawregulation.setLastId(last.getId());
            lawregulation.setLastTitle(last.getTitle());
        }

        if (null != next) {
            lawregulation.setNextId(next.getId());
            lawregulation.setNextTitle(next.getTitle());
        }

        return lawregulation;
    }

    // @Override
    // public IPage<Lawregulation> page(Integer page) {
    //     Page<Lawregulation> lawregulationPage = new Page<>();
    //     lawregulationPage.setSize(Constant.DEFAULT.getSIZE());
    //     return getBaseMapper().selectPage(lawregulationPage, null);
    // }
}
