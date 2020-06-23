package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.News;
import org.whystudio.alumfound.mapper.NewsMapper;
import org.whystudio.alumfound.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
