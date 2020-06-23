package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Picnews;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 图片新闻 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IPicnewsService extends IService<Picnews> {

    IPage<Picnews> page(Integer page);

    Picnews picNews(Long id);

}
