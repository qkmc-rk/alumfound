package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Yearlyreport;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 信息公开 - 年度报告 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IYearlyreportService extends IService<Yearlyreport> {

    Response yearlyreportList(Integer currentPage, Integer size);

    Response oneYearlyreport(Long id);
}
