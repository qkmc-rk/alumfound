package org.whystudio.alumfound.service.impl;

import org.whystudio.alumfound.entity.File;
import org.whystudio.alumfound.mapper.FileMapper;
import org.whystudio.alumfound.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 下载文件信息 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
