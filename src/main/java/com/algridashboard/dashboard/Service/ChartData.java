package com.algridashboard.dashboard.Service;

import com.algridashboard.dashboard.mapper.TemperatureMapper;
import com.algridashboard.dashboard.model.AllChart;
import com.algridashboard.dashboard.model.Datasets;
import com.algridashboard.dashboard.model.Temperature;
import com.algridashboard.dashboard.util.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("test")
public class ChartData {
    @Autowired
    private TemperatureMapper temperatureMapper;


    public  Temperature getById(){
        Temperature tmp=new Temperature();
        tmp.setTemp("22");
        tmp.setTime("22");
        temperatureMapper.insert(tmp);
       return tmp;
    }

public JsonResult getsmallchart (){
    JsonResult r=new JsonResult();
    AllChart all1 = new AllChart();
    AllChart all2=new AllChart();
    String []labels={null,null,null,null};
    Datasets datas=new Datasets();
    Integer[] data={9, 9, 9, 3};
    datas.setAll(data,"Today","start","rgba(0,123,255,0.1)","rgba(0,123,255,1)");
    Datasets [] dataset={datas};
    all1.setAll("label111","333","12.5%",false,true,labels,dataset);
    all2.setAll("label111","333","12.5%",false,true,labels,dataset);
    AllChart []all= {all1,all2};


    Map<String, Object> map = new HashMap<>(2);

    map.put("smallStats",all);
    r.setSmallStats(map);
    r.setMsg("message");
    return r;

    }



}







