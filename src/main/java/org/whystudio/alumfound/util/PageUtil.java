package org.whystudio.alumfound.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @description: 将pageSize和currentPage封装为page对象
 * @author: CoderM
 * @date: 2020/7/29 20:52
 */
public class PageUtil {

    private final static Integer defaultCurrentPage = 1;
    private final static Integer defaultPageSize = 5;


    public static Page<Object> generatePage(Integer currentPage, Integer pageSize) {

        Page<Object> page = new Page<>();

        page.setCurrent(null == currentPage ? defaultCurrentPage : currentPage);
        page.setSize(null == pageSize ? defaultPageSize : pageSize);

        return page;
    }


}
