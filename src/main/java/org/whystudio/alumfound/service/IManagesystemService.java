package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Managesystem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理制度 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IManagesystemService extends IService<Managesystem> {

    IPage<Managesystem> page(Integer page);

    Managesystem getById(Long id);

}
