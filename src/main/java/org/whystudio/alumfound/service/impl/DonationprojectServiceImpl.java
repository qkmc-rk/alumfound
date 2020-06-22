package org.whystudio.alumfound.service.impl;

import org.whystudio.alumfound.entity.Donationproject;
import org.whystudio.alumfound.mapper.DonationprojectMapper;
import org.whystudio.alumfound.service.IDonationprojectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 捐赠项目信息 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class DonationprojectServiceImpl extends ServiceImpl<DonationprojectMapper, Donationproject> implements IDonationprojectService {

    @Override
    public Response donationprojectList() {
        return ResponseUtil.autoJudgeByData(getBaseMapper().selectList(null));
    }
}
