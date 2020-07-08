package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.whystudio.alumfound.constant.SQLResult;
import org.whystudio.alumfound.entity.Alumniinfo;
import org.whystudio.alumfound.mapper.AlumniinfoMapper;
import org.whystudio.alumfound.service.IAlumniinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 前端采集并登记校友信息 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class AlumniinfoServiceImpl extends ServiceImpl<AlumniinfoMapper, Alumniinfo> implements IAlumniinfoService {

    @Override
    public Integer saveInfo(Alumniinfo alumniinfo) {
        //手机号验证,防止重复认证
        if (getAlumniinfoByPhone(alumniinfo.getContact()) != null) {
            return SQLResult.EXIST_DATA;
        }
        return getBaseMapper().insert(alumniinfo);
    }

    @Override
    public Alumniinfo getAlumniinfoByPhone(String phone) {
        QueryWrapper<Alumniinfo> stringQueryWrapper = new QueryWrapper<>();
        stringQueryWrapper.eq("contract", phone);
        return getBaseMapper().selectOne(stringQueryWrapper);
    }

    @Override
    public Alumniinfo getAlumniinfo(Long id) {
        return getBaseMapper().selectById(id);
    }
}
