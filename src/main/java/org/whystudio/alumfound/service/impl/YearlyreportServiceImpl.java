package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Donationlist;
import org.whystudio.alumfound.entity.Yearlyreport;
import org.whystudio.alumfound.mapper.YearlyreportMapper;
import org.whystudio.alumfound.service.IYearlyreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开 - 年度报告 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class YearlyreportServiceImpl extends ServiceImpl<YearlyreportMapper, Yearlyreport> implements IYearlyreportService {

    @Override
    public Response yearlyreportList(Integer currentPage, Integer size) {
        IPage<Yearlyreport> page = new Page<>();
        page.setCurrent(currentPage == null? Constant.DEFAULT.getCURRENT_PAGE(): currentPage);
        page.setSize(size == null? Constant.DEFAULT.getSIZE(): size);
        return ResponseUtil.autoJudgeByData(getBaseMapper().selectPage(page, null));
    }

    @Override
    public Response oneYearlyreport(Long id) {
        if (id < 0){
            return ResponseUtil.failWithoutData("error id: " + id);
        }
        return ResponseUtil.autoJudgeByData(getBaseMapper().selectById(id));
    }
}
