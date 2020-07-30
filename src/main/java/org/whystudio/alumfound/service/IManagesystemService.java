package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.entity.Managesystem;
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

    Managesystem selectManageSystem(Long id);

    // Response oneManagesystem(Long id);

    // IPage<Managesystem> page(Integer page);

    // Managesystem getById(Long id);
}
