package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Managesystem;
import org.whystudio.alumfound.entity.Picnews;
import org.whystudio.alumfound.mapper.PicnewsMapper;
import org.whystudio.alumfound.service.IPicnewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
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
    public Response onePicnews(Long id) {
        if (id < 0L){
            return ResponseUtil.failWithoutData("error id:" + id);
        }
        Picnews picnews = getBaseMapper().selectById(id);
        return ResponseUtil.autoJudgeByData(picnews);
    }
}
