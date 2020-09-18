package com.algridashboard.dashboard.Service;

import com.algridashboard.dashboard.mapper.TemperatureMapper;
import com.algridashboard.dashboard.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("test")
public class test {
    @Autowired
    private TemperatureMapper temperatureMapper;


    public  Temperature getById(){
        Temperature tmp=new Temperature();
        tmp.setTemp("22");
        tmp.setTime("22");
        temperatureMapper.insert(tmp);
       return tmp;
    }}







