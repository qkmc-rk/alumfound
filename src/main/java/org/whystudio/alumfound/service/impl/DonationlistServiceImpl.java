package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Donationlist;
import org.whystudio.alumfound.mapper.DonationlistMapper;
import org.whystudio.alumfound.service.IDonationlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开-捐赠名单 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class DonationlistServiceImpl extends ServiceImpl<DonationlistMapper, Donationlist> implements IDonationlistService {

    @Override
    public Response donationlistList(Integer currentPage, Integer size) {
        IPage<Donationlist> page = new Page<>();
        page.setCurrent(currentPage == null? Constant.DEFAULT.getCURRENT_PAGE(): currentPage);
        page.setSize(size == null? Constant.DEFAULT.getSIZE(): size);
        return ResponseUtil.autoJudgeByData(getBaseMapper().selectPage(page, null));
    }

    @Override
    public Response oneDonationlist(Long id) {
        if (id < 0){
            return ResponseUtil.failWithoutData("error id:" + id);
        }
        return ResponseUtil.autoJudgeByData(getBaseMapper().selectById(id));
    }
}
