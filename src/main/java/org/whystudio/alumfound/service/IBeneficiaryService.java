package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Beneficiary;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 受益人信息公示 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IBeneficiaryService extends IService<Beneficiary> {

    /**
     * 返回列表 具有分页功能
     * @param currentPage
     * @param size
     * @return
     */
    Response beneficiaryList(Integer currentPage, Integer size);

    Response beneficiary(Long id);
}
