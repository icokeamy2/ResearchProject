package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Warn;
import com.algridashboard.dashboard.util.BaseMapper;

public interface WarnMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warn record);

    int insertSelective(Warn record);

    Warn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKey(Warn record);

    Warn[] selectNewest5();
}