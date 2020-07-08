package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Managesystem;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 管理制度 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IManagesystemService extends IService<Managesystem> {

    Response managesystemList(Integer currentPage, Integer size);

    Response oneManagesystem(Long id);
    IPage<Managesystem> page(Integer page);

    Managesystem getById(Long id);


}
