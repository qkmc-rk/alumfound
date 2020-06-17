package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Elsepubinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 公开信息- 其它公示 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IElsepubinfoService extends IService<Elsepubinfo> {

    /**
     *  返回一条其它公示中的详细信息
     * @param id
     * @return
     */
    Response oneElsePubInfo(Long id);

    /**
     * 返回列表 有分页 如果前端不传分页数据， 返回第一页的五条数据
     * @return
     * @param currentPage
     * @param size
     */
    Response elsePubInfoList(Integer currentPage, Integer size);
}
