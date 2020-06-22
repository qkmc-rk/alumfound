package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Alumnimien;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 校友风采 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IAlumnimienService extends IService<Alumnimien> {

    Response alumnimienList(Integer currentPage, Integer size);

    Response oneAlumnimien(Long id);
}
