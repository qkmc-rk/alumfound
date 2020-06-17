package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Beneficiary;
import org.whystudio.alumfound.entity.Elsepubinfo;
import org.whystudio.alumfound.mapper.BeneficiaryMapper;
import org.whystudio.alumfound.service.IBeneficiaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 受益人信息公示 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class BeneficiaryServiceImpl extends ServiceImpl<BeneficiaryMapper, Beneficiary> implements IBeneficiaryService {

    @Override
    public Response beneficiaryList(Integer currentPage, Integer size) {
        Page<Beneficiary> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        IPage<Beneficiary> elsepubinfoPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), null);
        return ResponseUtil.autoJudgeByData(elsepubinfoPage);
    }

    @Override
    public Response beneficiary(Long id) {
        if (id < 0L){
            return ResponseUtil.failWithoutData("error id:" + id);
        }
        Beneficiary beneficiary = getById(id);
        return ResponseUtil.autoJudgeByData(beneficiary);
    }
}
