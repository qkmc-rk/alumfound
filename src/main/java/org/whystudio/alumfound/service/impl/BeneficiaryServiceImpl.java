package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Beneficiary;
import org.whystudio.alumfound.mapper.BeneficiaryMapper;
import org.whystudio.alumfound.service.IBeneficiaryService;
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
    public Beneficiary selectBeneficiary(Long id) {
        Beneficiary beneficiary = getBaseMapper().selectById(id);


        if (null == beneficiary) {
            return null;
        }

        Beneficiary last = getBaseMapper().selectOne(
                Wrappers.<Beneficiary>lambdaQuery()
                        .gt(Beneficiary::getModified, beneficiary.getModified())
                        .orderByAsc(Beneficiary::getModified)
                        .last("limit 1")
        );

        Beneficiary next = getBaseMapper().selectOne(

                Wrappers.<Beneficiary>lambdaQuery()
                        .lt(Beneficiary::getModified, beneficiary.getModified())
                        .orderByDesc(Beneficiary::getModified)
                        .last("limit 1")

        );

        if (null != last) {
            beneficiary.setLastId(last.getId());
            beneficiary.setLastTitle(last.getTitle());
        }

        if (null != next) {
            beneficiary.setNextId(next.getId());
            beneficiary.setNextTitle(next.getTitle());
        }

        return beneficiary;
    }

    // @Override
    // public Response beneficiary(Long id) {
    //     if (id < 0L){
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     Beneficiary beneficiary = getById(id);
    //     return ResponseUtil.autoJudgeByData(beneficiary);
    // }
}
