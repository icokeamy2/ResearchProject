package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Humidity;
import com.algridashboard.dashboard.util.BaseMapper;

public interface HumidityMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Humidity record);

    int insertSelective(Humidity record);

    Humidity selectByPrimaryKey(Integer id);
    Humidity[] selectNewest5();
    int selectCount(String starttime,String endtime);
    Humidity[] selectByTime(String starttime,String endtime);
    int totalCount();

    int updateByPrimaryKeySelective(Humidity record);

    int updateByPrimaryKey(Humidity record);
}