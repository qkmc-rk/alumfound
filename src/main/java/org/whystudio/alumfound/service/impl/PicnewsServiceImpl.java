package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.whystudio.alumfound.entity.Picnews;
import org.whystudio.alumfound.mapper.PicnewsMapper;
import org.whystudio.alumfound.service.IPicnewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片新闻 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class PicnewsServiceImpl extends ServiceImpl<PicnewsMapper, Picnews> implements IPicnewsService {

    @Override
    public IPage<Picnews> page(Integer page) {
        Page<Picnews> picnewsPage = new Page<>();
        picnewsPage.addOrder(OrderItem.desc("created"));
        return getBaseMapper().selectPage(picnewsPage, null);
    }

    @Override
    public Picnews picNews(Long id) {
        return getBaseMapper().selectById(id);
    }
}
