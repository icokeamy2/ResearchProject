package com.algridashboard.dashboard.Service;

import com.algridashboard.dashboard.mapper.HumidityMapper;
import com.algridashboard.dashboard.mapper.LocaMapper;
import com.algridashboard.dashboard.mapper.TemperatureMapper;
import com.algridashboard.dashboard.mapper.WarnMapper;
import com.algridashboard.dashboard.model.*;
import com.algridashboard.dashboard.util.JsonResult;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("test")
public class ChartData {
    @Autowired
    private TemperatureMapper temperatureMapper;
    @Autowired
    private HumidityMapper humidityMapper;
    @Autowired
    private WarnMapper warnMapper;
    @Autowired
    private LocaMapper locaMapper;


    public  Temperature getById(){
        Temperature tmp=new Temperature();
        tmp.setTemperature(27.0);
        tmp.setTime("22");
        Temperature tt=temperatureMapper.selectByPrimaryKey(1);
        System.out.println(tt);
       return tmp;
    }

public JsonResult getsmallchart (){

    JsonResult r=new JsonResult();
    AllChart all1 = new AllChart();
    AllChart all2=new AllChart();
    AllChart all3=new AllChart();
 //define time intervals
    long currentTime = System.currentTimeMillis() ;
    System.out.println(currentTime);
    //currentTime=currentTime+150*60*1000;
    //System.out.println(currentTime);
    long[]intervals={currentTime-40000,currentTime-80000,currentTime-120000,currentTime-160000};

    //humidity
    Integer []humicount=new Integer[4];
    humicount[3]=humidityMapper.selectCount(String.valueOf(intervals[0]),String.valueOf(currentTime));
    humicount[2]=humidityMapper.selectCount(String.valueOf(intervals[1]),String.valueOf(intervals[0]));
    humicount[1]=humidityMapper.selectCount(String.valueOf(intervals[2]),String.valueOf(intervals[1]));
    humicount[0]=humidityMapper.selectCount(String.valueOf(intervals[3]),String.valueOf(intervals[2]));
    String huminumber=String.valueOf(humidityMapper.totalCount());
    String []labels={null,null,null,null};
    Datasets humidatas=new Datasets();
    humidatas.setAll(humicount,"All","start","rgba(0,123,255,0.1)","rgba(0,123,255,1)");
    Datasets [] humidataset={humidatas};
    if(humicount[3]>humicount[2]){
        double humipersentage= (double)(humicount[3]-humicount[2])/humicount[2]*100;
        all1.setAll("Humidity",huminumber,humipersentage+"%",true,false,labels,humidataset);
        if(humipersentage>200){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Humidity data increase"+humipersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }
    }
    else if(humicount[3]<humicount[2]){
        double humipersentage= (double)(humicount[2]-humicount[3])/humicount[2]*100;
        all1.setAll("Humidity",huminumber,humipersentage+"%",false,true,labels,humidataset);
        //lost data, trigger warning
        if(humipersentage>80){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Humidity data decrease"+humipersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }

    }
    else{
        all1.setAll("Humidity",huminumber,"0%",true,false,labels,humidataset);

    }
//temperature
    Integer []tempcount=new Integer[4];
    tempcount[3]=temperatureMapper.selectCount(String.valueOf(intervals[0]),String.valueOf(currentTime));
    tempcount[2]=temperatureMapper.selectCount(String.valueOf(intervals[1]),String.valueOf(intervals[0]));
    tempcount[1]=temperatureMapper.selectCount(String.valueOf(intervals[2]),String.valueOf(intervals[1]));
    tempcount[0]=temperatureMapper.selectCount(String.valueOf(intervals[3]),String.valueOf(intervals[2]));
    String tempnumber=String.valueOf(temperatureMapper.totalCount());
    Datasets tempdatas=new Datasets();
    tempdatas.setAll(tempcount,"All","start","rgba(0,123,255,0.1)","rgba(0,123,255,1)");
    Datasets [] tempdataset={tempdatas};
    if(tempcount[3]>tempcount[2]){
        double temppersentage= (double)(tempcount[3]-tempcount[2])/tempcount[2]*100;
        all2.setAll("Temperature",tempnumber,temppersentage+"%",true,false,labels,tempdataset);
        if(temppersentage>200){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Temperature data increase"+temppersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }
    }
    else if(tempcount[3]<tempcount[2]){
        double temppersentage= (double)(tempcount[2]-tempcount[3])/tempcount[2]*100;
        all2.setAll("Temperature",tempnumber,temppersentage+"%",false,true,labels,tempdataset);
        if(temppersentage>80){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Temperature data decrease"+temppersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }
    }
    else{
        all2.setAll("Temperature",tempnumber,"0%",true,false,labels,tempdataset);
    }

    //location
    Integer []loccount=new Integer[4];
    loccount[3]=locaMapper.selectCount(String.valueOf(intervals[0]),String.valueOf(currentTime));
    loccount[2]=locaMapper.selectCount(String.valueOf(intervals[1]),String.valueOf(intervals[0]));
    loccount[1]=locaMapper.selectCount(String.valueOf(intervals[2]),String.valueOf(intervals[1]));
    loccount[0]=locaMapper.selectCount(String.valueOf(intervals[3]),String.valueOf(intervals[2]));
    String locnumber=String.valueOf(locaMapper.totalCount());
    Datasets locpdatas=new Datasets();
    locpdatas.setAll(loccount,"All","start","rgba(0,123,255,0.1)","rgba(0,123,255,1)");
    Datasets [] locdataset={locpdatas};
    if(loccount[3]>loccount[2]){
        double locpersentage= (double)(loccount[3]-loccount[2])/loccount[2]*100;
        all3.setAll("Location",locnumber,locpersentage+"%",true,false,labels,locdataset);
        if(locpersentage>200){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Location data increase"+locpersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }
    }
    else if(loccount[3]<loccount[2]){
        double locpersentage= (double)(loccount[2]-loccount[3])/loccount[2]*100;
        all3.setAll("Location",locnumber,locpersentage+"%",false,true,labels,locdataset);
        if(locpersentage>200){
            Warn humiwarn=new Warn();
            humiwarn.setContent("Abnormal Location data decrease"+locpersentage+"%");
            humiwarn.setTime(String.valueOf(currentTime));
            humiwarn.setType("Warning");
            warnMapper.insert(humiwarn);
        }
    }
    else{
        all3.setAll("Location",locnumber,"0%",true,false,labels,locdataset);
    }


      AllChart []all= {all1,all2,all3};


    Map<String, Object> map = new HashMap<>(2);

    map.put("smallStats",all);
    r.setSmallStats(map);
    r.setMsg("message");
    return r;

    }
    public JsonResult getsessionchart (String type, String starttime,String endtime){
        JsonResult r=new JsonResult();
        SessionChart chart=new SessionChart();
        Date date = new Date();
        long currentTime = System.currentTimeMillis() ;
        //long lastdatyTime=currentTime-24*60*60*1000;
        int hours = date.getHours();
        ArrayList<String> la=new ArrayList<>();
        ArrayList<Integer>da1=new ArrayList<>();
        ArrayList<Integer>da2=new ArrayList<>();
//        String []labels=new String[50];
//        Integer []data1= new Integer[50];
//        Integer []data2= new Integer[50];
        String data1Tag="";
        String data2Tag="";



        if(type.equals("Humidity")){
            if(starttime.equals("") || endtime.equals("") ||starttime.equals("0") ||endtime.equals("0") ){
                data1Tag="Today";
                data2Tag="Yesterday";

                for(int i=0;i<hours;i++){
                    la.add(i+":00");
//                    la[i]=i+":00";
                    long start=currentTime-(hours-i)*60*60*1000;
                    long end=currentTime-(hours-1-i)*60*60*1000;
                    long laststart=start-24*60*60*1000;
                    long lastend=end-24*60*60*1000;
                    da1.add(humidityMapper.selectTopByTime(String.valueOf(start),String.valueOf(end)).getHumidity().intValue());
                    da2.add(humidityMapper.selectTopByTime(String.valueOf(laststart),String.valueOf(lastend)).getHumidity().intValue());


                }
//                Integer[] data1=humidity;
//                Integer[] data2=oldhumidity;
            }
            else{

//                Integer []highesthumidity= new Integer[50];
//                Integer []lowesthumidity= new Integer[50];
                data1Tag="Highest Humidity";
                data2Tag="Lowest Humidity";
                long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2018-06-30 20:00:00", new ParsePosition(0)).getTime();
                String start=starttime.split("T")[0]+" 00:00:00";
                String end=endtime.split("T")[0]+" 23:59:59";
                long stamp1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(start, new ParsePosition(0)).getTime()+24*60*60*1000;
                long stamp2=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(end, new ParsePosition(0)).getTime()+24*60*60*1000;
                long startstamp=stamp1-150*60*1000;
                long endstamp=stamp2-150*60*1000;
                int i=0;
                for(long j=startstamp;j<endstamp;j=j+24*60*60*1000){
                    da1.add(humidityMapper.selectHighestByTime(String.valueOf(j),String.valueOf(j+24*60*60*1000)).getHumidity().intValue());
                    da2.add(humidityMapper.selectLowestByTime(String.valueOf(j),String.valueOf(j+24*60*60*1000)).getHumidity().intValue());
//                    double time2 = 1515730332000d;
//                    String result2 = new SimpleDateFormat("yyyy-MM-dd").format(j+150*60*1000);
//                    System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
                    la.add(new SimpleDateFormat("yyyy-MM-dd").format(j+151*60*1000));
                    i++;
                }
           }

        }
        else{

            if(starttime.equals("") || endtime.equals("") ||starttime.equals("0") ||endtime.equals("0") ){
                data1Tag="Today";
                data2Tag="Yesterday";

                for(int i=0;i<hours;i++){
                    la.add(i+":00");
//                    la[i]=i+":00";
                    long start=currentTime-(hours-i)*60*60*1000;
                    long end=currentTime-(hours-1-i)*60*60*1000;
                    long laststart=start-24*60*60*1000;
                    long lastend=end-24*60*60*1000;
                    da1.add(temperatureMapper.selectTopByTime(String.valueOf(start),String.valueOf(end)).getTemperature().intValue());
                    da2.add(temperatureMapper.selectTopByTime(String.valueOf(laststart),String.valueOf(lastend)).getTemperature().intValue());


                }
//                Integer[] data1=humidity;
//                Integer[] data2=oldhumidity;
            }
            else{

//                Integer []highesthumidity= new Integer[50];
//                Integer []lowesthumidity= new Integer[50];
                data1Tag="Highest Temperature";
                data2Tag="Lowest Temperature";
                long time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2018-06-30 20:00:00", new ParsePosition(0)).getTime();
                String start=starttime.split("T")[0]+" 00:00:00";
                String end=endtime.split("T")[0]+" 23:59:59";
                long stamp1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(start, new ParsePosition(0)).getTime()+24*60*60*1000;
                long stamp2=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(end, new ParsePosition(0)).getTime()+24*60*60*1000;
                long startstamp=stamp1-150*60*1000;
                long endstamp=stamp2-150*60*1000;
                int i=0;
                for(long j=startstamp;j<endstamp;j=j+24*60*60*1000){
                    da1.add(temperatureMapper.selectHighestByTime(String.valueOf(j),String.valueOf(j+24*60*60*1000)).getTemperature().intValue());
                    da2.add(temperatureMapper.selectLowestByTime(String.valueOf(j),String.valueOf(j+24*60*60*1000)).getTemperature().intValue());
//                    double time2 = 1515730332000d;
//                    String result2 = new SimpleDateFormat("yyyy-MM-dd").format(j+150*60*1000);
//                    System.out.println("13位数的时间戳（毫秒）--->Date:" + result2);
                    la.add(new SimpleDateFormat("yyyy-MM-dd").format(j+151*60*1000));
                    i++;
                }
            }
        }

//        String []labels={"09:00 PM",
//                "10:00 PM",
//                "11:00 PM",
//                "12:00 PM",
//                "13:00 PM",
//                "14:00 PM",
//                "15:00 PM",
//                "16:00 PM",
//                "17:00 PM"};
        String []labels=la.toArray(new String[la.size()]);

Integer []data1= da1.toArray(new Integer[da1.size()]);
        Integer []data2= da2.toArray(new Integer[da2.size()]);
//        Integer []data2= new Integer[50];
        SessionDataset datas1=new SessionDataset();
        SessionDataset datas2=new SessionDataset();
//        Integer[] data1={1,0, 10, 30, 10, 42, 5, 15, 5};
//        Integer[] data2={5,23, 5, 10, 5, 5, 30, 2, 10};

        datas1.setAll(data1,data1Tag,"start","rgba(0,123,255,0.1)","rgba(0,123,255,1)", "#ffffff","rgba(0,123,255,1)",1.5);
//        if(!starttime.equals("1")){
            datas2.setAll(data2,data2Tag,"start","rgba(255,65,105,0.1)","rgba(255,65,105,1)", "#ffffff","rgba(255,65,105,1)",1.5);
//
//        }else{
//            datas2.setAll(data2,"OOOOOO","start","rgba(255,65,105,0.1)","rgba(255,65,105,1)", "#ffffff","rgba(255,65,105,1)",1.5);


        //}

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

    public JsonResult getPercentChart (){
        JsonResult r=new JsonResult();
        String[] labels={"Temperature", "Humidity", "Soil micronutrients"};
        Double[] data={50.0, 50.0, 0.0};
        ArrayList<roundDataSet> datasets=new ArrayList<>();
        roundDataSet datas=new roundDataSet();
        roundChart roundchartData=new roundChart();
        datas.setData(data);
        datasets.add(datas);


        roundchartData.setAll(labels,datasets);
        System.out.println(roundchartData);
        Map<String, Object> map = new HashMap<>(2);

        map.put("roundchartData",roundchartData);
        r.setSmallStats(map);
        r.setMsg("message");
        return r;

    }
    public JsonResult getMap (){
        JsonResult r=new JsonResult();
        location loca=new location();
        loca.setAll(42.3954,2.162);
        MapData location=new MapData();
        location.setAll("Sensor",loca);
        Map<String, Object> map = new HashMap<>(2);

        map.put("location",location);
        r.setSmallStats(map);
        r.setMsg("message");
        return r;

    }



}







