package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Beneficiary;
import org.whystudio.alumfound.entity.Elsepubinfo;
import org.whystudio.alumfound.mapper.ElsepubinfoMapper;
import org.whystudio.alumfound.service.IElsepubinfoService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 公开信息- 其它公示 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class ElsepubinfoServiceImpl extends ServiceImpl<ElsepubinfoMapper, Elsepubinfo> implements IElsepubinfoService {


    // @Override
    // public Response oneElsePubInfo(Long id) {
    //     // 数据校验框架
    //     if (id < 0L){
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     Elsepubinfo elsepubinfo = getBaseMapper().selectById(id);
    //     return ResponseUtil.autoJudgeByData(elsepubinfo);
    // }


    @Override
    public Response elsePubInfoList(Integer currentPage, Integer size) {
        IPage<Elsepubinfo> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        IPage<Elsepubinfo> elsepubinfoPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), null);
        return ResponseUtil.autoJudgeByData(elsepubinfoPage);
    }

    @Override
    public Elsepubinfo selectElsePubInfo(Long id) {
        Elsepubinfo elsepubinfo = getBaseMapper().selectById(id);


        if (null == elsepubinfo) {
            return null;
        }

        Elsepubinfo last = getBaseMapper().selectOne(
                Wrappers.<Elsepubinfo>lambdaQuery()
                        .gt(Elsepubinfo::getModified, elsepubinfo.getModified())
                        .orderByAsc(Elsepubinfo::getModified)
                        .last("limit 1")
        );

        Elsepubinfo next = getBaseMapper().selectOne(

                Wrappers.<Elsepubinfo>lambdaQuery()
                        .lt(Elsepubinfo::getModified, elsepubinfo.getModified())
                        .orderByDesc(Elsepubinfo::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            elsepubinfo.setLastId(last.getId());
            elsepubinfo.setLastTitle(last.getTitle());
        }

        if (null != next) {
            elsepubinfo.setNextId(next.getId());
            elsepubinfo.setNextTitle(next.getTitle());
        }

        return elsepubinfo;

    }
}
