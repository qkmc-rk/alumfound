package org.whystudio.alumfound.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.News;
import org.whystudio.alumfound.mapper.NewsMapper;
import org.whystudio.alumfound.service.INewsService;
import org.whystudio.alumfound.util.ResponseUtil;
import org.whystudio.alumfound.vo.Response;

/**
 * <p>
 * 普通新闻 服务实现类
 * </p>
 *
 * @author Mrruan
 * @since 2020-06-10
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Override
    public News selectNew(Long id) {
        News aNew = getBaseMapper().selectById(id);

        if (null == aNew) {
            return null;
        }

        News last = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .gt(News::getModified, aNew.getModified())
                        .orderByAsc(News::getModified)
                        .last("limit 1")

        );

        News next = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .lt(News::getModified, aNew.getModified())
                        .orderByDesc(News::getModified)
                        .last("limit 1")
        );

        if (null!=last) {
            aNew.setLastId(last.getId());
            aNew.setLastTitle(last.getTitle());

        }

        if (null !=next) {
            aNew.setNextId(next.getId());
            aNew.setNextTitle(next.getTitle());
        }

        return aNew;
    }

    @Override
    public Response newsList(Integer currentPage, Integer size) {
        IPage<News> page = new Page<>();
        if (null == currentPage || size == null){
            currentPage = 1;
            size = 5;
        }
        QueryWrapper<News> queryWrapper = Wrappers.query();
        queryWrapper.orderByDesc("modified");
        IPage<News> newsPage = getBaseMapper().selectPage(page.setCurrent(currentPage).setSize(size), queryWrapper);
        // 暂时把content留着吧
        return ResponseUtil.autoJudgeByData(newsPage);
    }

    @Override
    public News selectAlumniNew(Long id) {

        News aNew = getBaseMapper().selectById(id);

        if (null == aNew) {
            return null;
        }

        News last = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .eq(News::getIsFoundation,0)
                        .gt(News::getModified, aNew.getModified())
                        .orderByAsc(News::getModified)
                        .last("limit 1")

        );

        News next = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .eq(News::getIsFoundation,0)
                        .lt(News::getModified, aNew.getModified())
                        .orderByDesc(News::getModified)
                        .last("limit 1")
        );

        if (null!=last) {
            aNew.setLastId(last.getId());
            aNew.setLastTitle(last.getTitle());

        }

        if (null !=next) {
            aNew.setNextId(next.getId());
            aNew.setNextTitle(next.getTitle());
        }

        return aNew;

    }



    @Override
    public IPage<News> selectAlumniNewsList(Integer currentPage, Integer size) {
        Page<News> page = new Page<>();

        page.setCurrent(null == currentPage ? 1 : currentPage);
        page.setSize(null == size ? 5 : size);


        IPage<News> dataPage = getBaseMapper().selectPage(page,
                Wrappers.<News>lambdaQuery()
                        .orderByDesc(News::getModified)
                        .eq(News::getIsFoundation,0)
        );

        return dataPage;
    }

    @Override
    public News selectFoundationNew(Long id) {
        News aNew = getBaseMapper().selectById(id);

        if (null == aNew) {
            return null;
        }

        News last = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .eq(News::getIsFoundation,1)
                        .gt(News::getModified, aNew.getModified())
                        .orderByAsc(News::getModified)
                        .last("limit 1")

        );

        News next = getBaseMapper().selectOne(
                Wrappers.<News>lambdaQuery()
                        .eq(News::getIsFoundation,1)
                        .lt(News::getModified, aNew.getModified())
                        .orderByDesc(News::getModified)
                        .last("limit 1")
        );

        if (null!=last) {
            aNew.setLastId(last.getId());
            aNew.setLastTitle(last.getTitle());

        }

        if (null !=next) {
            aNew.setNextId(next.getId());
            aNew.setNextTitle(next.getTitle());
        }

        return aNew;
    }

    @Override
    public IPage<News> selectFoundationNewsList(Integer currentPage, Integer size) {
        Page<News> page = new Page<>();

        page.setCurrent(null == currentPage ? 1 : currentPage);
        page.setSize(null == size ? 5 : size);


        IPage<News> dataPage = getBaseMapper().selectPage(page,
                Wrappers.<News>lambdaQuery()
                        .orderByDesc(News::getModified)
                        .eq(News::getIsFoundation,1)
        );

        return dataPage;
    }


    // @Override
    // public Response oneNews(Long id) {
    //     if (id < 0L) {
    //         return ResponseUtil.failWithoutData("error id:" + id);
    //     }
    //     News news = getBaseMapper().selectById(id);
    //     return ResponseUtil.autoJudgeByData(news);
    // }
    // @Override
    // public IPage<News> newsForPage(Integer page) {
    //     Page<News> newsPage = new Page<>();
    //     newsPage.setSize(Constant.DEFAULT.getSIZE());
    //     return getBaseMapper().selectPage(newsPage, null);
    // }

    // @Override
    // public News getNews(Long id) {
    //     return getBaseMapper().selectById(id);
    // }
}
