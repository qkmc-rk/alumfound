package org.whystudio.alumfound.service.impl;

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

}
