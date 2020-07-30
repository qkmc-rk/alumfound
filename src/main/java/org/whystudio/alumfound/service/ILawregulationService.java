package org.whystudio.alumfound.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.entity.Lawregulation;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 政策法规 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface ILawregulationService extends IService<Lawregulation> {

    Response lawregulationList(Integer currentPage, Integer size);

    // Response oneLawregulation(Long id);

    Lawregulation selectLawRegulation(Long id);
    // IPage<Lawregulation> page(Integer page);
}
