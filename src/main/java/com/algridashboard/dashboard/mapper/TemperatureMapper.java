package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Temperature;
import com.algridashboard.dashboard.util.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component
public interface TemperatureMapper extends BaseMapper<Temperature> {
    void insert(Temperature record);

    int insertSelective(Temperature record);
}