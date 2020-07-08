package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Alumniinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 前端采集并登记校友信息 服务类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
public interface IAlumniinfoService extends IService<Alumniinfo> {

    Integer saveInfo(Alumniinfo alumniinfo);

    Alumniinfo getAlumniinfoByPhone(String phone);

    Alumniinfo getAlumniinfo(Long id);

}
