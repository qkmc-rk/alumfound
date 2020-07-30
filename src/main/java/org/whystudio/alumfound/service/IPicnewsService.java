package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.entity.Picnews;
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

    Picnews selectPicnew(Long id);

    Picnews selectAlumniNew(Long id);

    IPage<Picnews> selectAlumniPicnewsList(Integer currentPage, Integer size);

    Picnews selectFoundationNew(Long id);

    IPage<Picnews> selectFoundationPicnewsList(Integer currentPage, Integer size);

    // Response onePicnews(Long id);

    // IPage<Picnews> page(Integer page);

    // Picnews picNews(Long id);

}
