package com.algridashboard.dashboard.Service;

import com.algridashboard.dashboard.mapper.TemperatureMapper;
import com.algridashboard.dashboard.model.*;
import com.algridashboard.dashboard.util.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("warn")
public class Warning {
    @Autowired
    private TemperatureMapper temperatureMapper;
    public JsonResult getWarning (){
        JsonResult r=new JsonResult();
        ArrayList<WarningTable> latestOrdersData=new ArrayList<>();
        WarningTable warn=new WarningTable();
        WarningTable warn2=new WarningTable();
        WarningTable warn3=new WarningTable();
        warn.setAll("Irrigate","15 November 2020 20:32","Suggestion");
        warn2.setAll("Abnormal data volume","16 November 2020 09:15","Warning");
        warn3.setAll("Abnormal sensor location","16 November 2020 10:25","Danger");
        latestOrdersData.add(warn);
        latestOrdersData.add(warn3);
        latestOrdersData.add(warn2);



        Map<String, Object> map = new HashMap<>(2);

        map.put("latestOrdersData",latestOrdersData);
        r.setSmallStats(map);
        r.setMsg("message");
        return r;
}
}
