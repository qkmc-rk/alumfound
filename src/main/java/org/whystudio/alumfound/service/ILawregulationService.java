package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.whystudio.alumfound.entity.Lawregulation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 政策法规 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface ILawregulationService extends IService<Lawregulation> {

    IPage<Lawregulation> page(Integer page);

}
