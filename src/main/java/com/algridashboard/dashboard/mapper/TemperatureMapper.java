package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Temperature;
import com.algridashboard.dashboard.util.BaseMapper;

public interface TemperatureMapper extends BaseMapper {
    int insert(Temperature record);

    int insertSelective(Temperature record);
}