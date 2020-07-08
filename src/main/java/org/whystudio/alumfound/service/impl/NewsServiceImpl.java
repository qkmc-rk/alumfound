package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.News;
import org.whystudio.alumfound.entity.Picnews;
import org.whystudio.alumfound.mapper.NewsMapper;
import org.whystudio.alumfound.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 普通新闻 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Override
    public Response newsList(Integer currentPage, Integer size) {
        IPage<News> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        QueryWrapper<News> queryWrapper = Wrappers.query();
        queryWrapper.orderByDesc("modified");
        IPage<News> newsPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), queryWrapper);
        // 暂时把content留着吧
        return ResponseUtil.autoJudgeByData(newsPage);
    }

    @Override
    public Response oneNews(Long id) {
        if (id < 0L) {
            return ResponseUtil.failWithoutData("error id:" + id);
        }
        News news = getBaseMapper().selectById(id);
        return ResponseUtil.autoJudgeByData(news);
    }
    @Override
    public IPage<News> newsForPage(Integer page) {
        Page<News> newsPage = new Page<>();
        newsPage.setSize(Constant.DEFAULT.getSIZE());
        return getBaseMapper().selectPage(newsPage, null);
    }

    @Override
    public News getNews(Long id) {
        return getBaseMapper().selectById(id);
    }
}
