package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 普通新闻 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface INewsService extends IService<News> {

    IPage<News> newsForPage(Integer page);

    News getNews(Long id);

}
