package com.algridashboard.dashboard.mapper;

import com.algridashboard.dashboard.model.Loca;
import com.algridashboard.dashboard.util.BaseMapper;

public interface LocaMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Loca record);

    int insertSelective(Loca record);

    Loca selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loca record);

    int updateByPrimaryKey(Loca record);

    Loca[] selectNewest5();
    int selectCount(String starttime,String endtime);
    Loca[] selectByTime(String starttime,String endtime);
    int totalCount();
}