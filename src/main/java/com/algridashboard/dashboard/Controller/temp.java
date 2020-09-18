package com.algridashboard.dashboard.Controller;

import com.algridashboard.dashboard.Service.test;
import com.algridashboard.dashboard.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller

    @RequestMapping("/student")
    public class temp {
        @Autowired
        private test test;

        @RequestMapping("/getById")
        @ResponseBody
        public Temperature getById(){
            return test.getById();
        }
    }

