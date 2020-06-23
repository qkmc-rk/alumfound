package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Alumnimien;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 校友风采 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IAlumnimienService extends IService<Alumnimien> {

    IPage<Alumnimien> getAlumnimienList(Integer page);

    Alumnimien getAlumnimien(Long id);

}
