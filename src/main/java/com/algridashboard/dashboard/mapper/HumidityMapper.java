package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Humidity;
import com.algridashboard.dashboard.util.BaseMapper;

public interface HumidityMapper extends BaseMapper {
    void deleteByPrimaryKey(String uuid);

    int insert(Humidity record);

    int insertSelective(Humidity record);

    Humidity selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Humidity record);

    int updateByPrimaryKey(Humidity record);
}