package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.entity.News;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 普通新闻 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface INewsService extends IService<News> {

    News selectNew(Long id);

    Response newsList(Integer currentPage, Integer size);

    News selectAlumniNew(Long id);

    IPage<News> selectAlumniNewsList(Integer currentPage, Integer size);

    News selectFoundationNew(Long id);

    IPage<News> selectFoundationNewsList(Integer currentPage, Integer size);



    // Response oneNews(Long id);

    // IPage<News> newsForPage(Integer page);

    // News getNews(Long id);
}
