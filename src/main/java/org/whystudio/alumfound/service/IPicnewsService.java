package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Picnews;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 图片新闻 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IPicnewsService extends IService<Picnews> {

    Response picnewsList(Integer currentPage, Integer size);

    Response onePicnews(Long id);
}
