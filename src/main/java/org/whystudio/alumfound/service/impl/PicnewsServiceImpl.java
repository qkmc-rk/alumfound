package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Picnews;
import org.whystudio.alumfound.mapper.PicnewsMapper;
import org.whystudio.alumfound.service.IPicnewsService;
import org.whystudio.alumfound.util.PageUtil;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 图片新闻 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class PicnewsServiceImpl extends ServiceImpl<PicnewsMapper, Picnews> implements IPicnewsService {

    @Override
    public Response picnewsList(Integer currentPage, Integer size) {
        IPage<Picnews> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        QueryWrapper<Picnews> queryWrapper = Wrappers.query();
        queryWrapper.orderByDesc("modified");
        IPage<Picnews> picnewsPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), queryWrapper);
        // 暂时把content留着吧
        return ResponseUtil.autoJudgeByData(picnewsPage);
    }

    @Override
    public Picnews selectPicnew(Long id) {
        Picnews picnews = getBaseMapper().selectById(id);


        if (null == picnews) {
            return null;
        }

        Picnews last = getBaseMapper().selectOne(
                Wrappers.<Picnews>lambdaQuery()
                        .gt(Picnews::getModified, picnews.getModified())
                        .orderByAsc(Picnews::getModified)
                        .last("limit 1")
        );

        Picnews next = getBaseMapper().selectOne(

                Wrappers.<Picnews>lambdaQuery()
                        .lt(Picnews::getModified, picnews.getModified())
                        .orderByDesc(Picnews::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            picnews.setLastId(last.getId());
            picnews.setLastTitle(last.getTitle());
        }

        if (null != next) {
            picnews.setNextId(next.getId());
            picnews.setNextTitle(next.getTitle());
        }

        return picnews;
    }

    @Override
    public Picnews selectAlumniNew(Long id) {

        Picnews picnews = getBaseMapper().selectById(id);


        if (null == picnews) {
            return null;
        }

        Picnews last = getBaseMapper().selectOne(
                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation,0)
                        .gt(Picnews::getModified, picnews.getModified())
                        .orderByAsc(Picnews::getModified)
                        .last("limit 1")
        );

        Picnews next = getBaseMapper().selectOne(

                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation,0)
                        .lt(Picnews::getModified, picnews.getModified())
                        .orderByDesc(Picnews::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            picnews.setLastId(last.getId());
            picnews.setLastTitle(last.getTitle());
        }

        if (null != next) {
            picnews.setNextId(next.getId());
            picnews.setNextTitle(next.getTitle());
        }

        return picnews;
    }

    @Override
    public IPage<Picnews> selectAlumniPicnewsList(Integer currentPage, Integer size) {
        Page page = PageUtil.generatePage(currentPage, size);

        IPage<Picnews> dataPage = getBaseMapper().selectPage(page,
                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation, 0)
                        .orderByDesc(Picnews::getModified)
        );

        return dataPage;
    }

    @Override
    public Picnews selectFoundationNew(Long id) {
        Picnews picnews = getBaseMapper().selectById(id);


        if (null == picnews) {
            return null;
        }

        Picnews last = getBaseMapper().selectOne(
                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation,1)
                        .gt(Picnews::getModified, picnews.getModified())
                        .orderByAsc(Picnews::getModified)
                        .last("limit 1")
        );

        Picnews next = getBaseMapper().selectOne(
                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation,1)
                        .lt(Picnews::getModified, picnews.getModified())
                        .orderByDesc(Picnews::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            picnews.setLastId(last.getId());
            picnews.setLastTitle(last.getTitle());
        }

        if (null != next) {
            picnews.setNextId(next.getId());
            picnews.setNextTitle(next.getTitle());
        }

        return picnews;
    }

    @Override
    public IPage<Picnews> selectFoundationPicnewsList(Integer currentPage, Integer size) {
        Page page = PageUtil.generatePage(currentPage, size);

        IPage<Picnews> dataPage = getBaseMapper().selectPage(page,
                Wrappers.<Picnews>lambdaQuery()
                        .eq(Picnews::getIsFoundation, 1)
                        .orderByDesc(Picnews::getModified)
        );

        return dataPage;
    }

    // @Override
    // public Response onePicnews(Long id) {
    //     if (id < 0L) {
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     Picnews picnews = getBaseMapper().selectById(id);
    //     return ResponseUtil.autoJudgeByData(picnews);
    // }
    // @Override
    // public IPage<Picnews> page(Integer page) {
    //     Page<Picnews> picnewsPage = new Page<>();
    //     picnewsPage.addOrder(OrderItem.desc("created"));
    //     return getBaseMapper().selectPage(picnewsPage, null);
    // }
    //
    // @Override
    // public Picnews picNews(Long id) {
    //     return getBaseMapper().selectById(id);
    // }
}
