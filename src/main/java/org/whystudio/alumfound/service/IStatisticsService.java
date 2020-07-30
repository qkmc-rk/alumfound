package org.whystudio.alumfound.service;

import org.whystudio.alumfound.entity.Statistics;

import java.util.Date;

/**
 * @description: 数据统计接口
 * @author: CoderM
 * @date: 2020/7/28 20:06
 */
public interface IStatisticsService {

    Boolean addVisitNumber(Statistics statistics);

    Statistics getVisitData(Date date);

    Long getTotalVisit();

}
