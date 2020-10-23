package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Temperature;
import com.algridashboard.dashboard.util.BaseMapper;

public interface TemperatureMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Temperature record);

    int insertSelective(Temperature record);

    Temperature selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Temperature record);

    int updateByPrimaryKey(Temperature record);
    Temperature[] selectNewest5();
    int selectCount(String starttime,String endtime);
    Temperature[] selectByTime(String starttime,String endtime);
    int totalCount();
}