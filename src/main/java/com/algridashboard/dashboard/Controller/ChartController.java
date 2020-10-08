package com.algridashboard.dashboard.Controller;

import com.algridashboard.dashboard.Service.ChartData;
import com.algridashboard.dashboard.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

    @RequestMapping("/dashboard")
    public class ChartController {
        @Autowired
        private ChartData small;

        @RequestMapping("/getSmallChart")
        @ResponseBody
        public JsonResult getById(){
            return small.getsmallchart();
        }

    }


