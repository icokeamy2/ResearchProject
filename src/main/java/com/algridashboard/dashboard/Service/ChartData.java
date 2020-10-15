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
    public JsonResult getsessionchart (){
        JsonResult r=new JsonResult();
        SessionChart chart=new SessionChart();

        String []labels={"09:00 PM",
                "10:00 PM",
                "11:00 PM",
                "12:00 PM",
                "13:00 PM",
                "14:00 PM",
                "15:00 PM",
                "16:00 PM",
                "17:00 PM"};
        SessionDataset datas1=new SessionDataset();
        SessionDataset datas2=new SessionDataset();
        Integer[] data1={1,0, 10, 30, 10, 42, 5, 15, 5};
        Integer[] data2={5,23, 5, 10, 5, 5, 30, 2, 10};

        datas1.setAll(data1,"Today","start","rgba(0,123,255,0.1)","rgba(0,123,255,1)", "#ffffff","rgba(0,123,255,1)",1.5);
        datas2.setAll(data2,"Yesterday","start","rgba(255,65,105,0.1)","rgba(255,65,105,1)", "#ffffff","rgba(255,65,105,1)",1.5);

        SessionDataset [] dataset={datas1,datas2};
        chart.setAll(labels,dataset);

        Map<String, Object> map = new HashMap<>(2);

        map.put("chartData",chart);
        r.setSmallStats(map);
        r.setMsg("message");
        return r;

    }



    public JsonResult getRanking (){
        JsonResult r=new JsonResult();
        ArrayList<referralData> referralData=new ArrayList<>();
        referralData rank1=new referralData();
        referralData rank2=new referralData();
        referralData rank3=new referralData();
        referralData rank4=new referralData();
        rank1.setAll("5","Irrigate");
        rank2.setAll("2","Abnormal data volume");
        rank3.setAll("1","Abnormal sensor location");
        rank4.setAll("1","Abnormal data delay");
        referralData.add(rank1);
        referralData.add(rank2);
        referralData.add(rank3);
        referralData.add(rank4);



        Map<String, Object> map = new HashMap<>(2);

        map.put("referralData",referralData);
        r.setSmallStats(map);
        r.setMsg("message");
        return r;

    }


}







