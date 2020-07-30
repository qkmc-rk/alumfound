package org.whystudio.alumfound.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.whystudio.alumfound.entity.Statistics;
import org.whystudio.alumfound.mapper.StatisticsMapper;
import org.whystudio.alumfound.service.IStatisticsService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 数据统计接口实现类
 * @author: CoderM
 * @date: 2020/7/28 20:52
 */
@Service
public class StatisticsServiceImpl implements IStatisticsService {

    @Resource
    StatisticsMapper statisticsMapper;

    @Override
    public Boolean addVisitNumber(Statistics newStatistics) {

        Statistics oldStatistics = statisticsMapper.selectOne(
                Wrappers.<Statistics>lambdaQuery()
                        .orderByDesc(Statistics::getDate_visit)
                        .last("limit 1")
        );

        Boolean flag = false;

        if (null == oldStatistics) {
            flag = statisticsMapper.insert(newStatistics) > 0;
        } else if (!newStatistics.getDate_visit().equals(oldStatistics.getDate_visit())) {
            newStatistics.setTotal_visit(oldStatistics.getToday_visit() + 1);
            flag = statisticsMapper.insert(newStatistics) > 0;
        } else {
            newStatistics.setId(oldStatistics.getId());
            newStatistics.setToday_visit(oldStatistics.getToday_visit() + 1);
            newStatistics.setTotal_visit(oldStatistics.getTotal_visit() + 1);
            flag = statisticsMapper.updateById(newStatistics) > 0;
        }
        return flag;
    }

    @Override
    public Statistics getVisitData(Date date) {
        Statistics statistics = statisticsMapper.selectOne(
                Wrappers.<Statistics>lambdaQuery()
                        .eq(Statistics::getDate_visit, date)
        );
        if (statistics == null) {
            statistics = statisticsMapper.selectOne(
                    Wrappers.<Statistics>lambdaQuery()
                            .orderByDesc(Statistics::getDate_visit)
                            .last("limit 1")
            );
        }
        return statistics;
    }

    @Override
    public Long getTotalVisit() {
        return null;
    }
}
