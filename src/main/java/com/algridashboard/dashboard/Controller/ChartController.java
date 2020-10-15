package com.algridashboard.dashboard.Controller;

import com.algridashboard.dashboard.Service.ChartData;
import com.algridashboard.dashboard.Service.Warning;
import com.algridashboard.dashboard.util.JsonResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

    @RequestMapping("/dashboard")
    public class ChartController {
        @Autowired
        private ChartData small;
        @Autowired
        private Warning warn;

        @RequestMapping("/getSmallChart")
        @ResponseBody
        public JsonResult getById(){
            return small.getsmallchart();
        }
    @RequestMapping("/getSessionChart")
    @ResponseBody
    public JsonResult getSessionChart(@RequestBody JSONObject jsonObject){
        String type = jsonObject.getString("type");
        String starttime = jsonObject.getString("starttime");
        String endtime = jsonObject.getString("endtime");

        return small.getsessionchart(type,starttime,endtime);
    }

    @RequestMapping("/getWarning")
    @ResponseBody
    public JsonResult getWarning(){
        return warn.getWarning();
    }

    @RequestMapping("/getRanking")
    @ResponseBody
    public JsonResult getRanking(){
        return small.getRanking();
    }

    @RequestMapping("/getPercentChart")
    @ResponseBody
    public JsonResult getPercentChart(){
        JsonResult chart=small.getPercentChart();

        return chart;
    }
    @RequestMapping("/getMap")
    @ResponseBody
    public JsonResult getMap(){
        JsonResult chart=small.getMap();
        return chart;
    }


}


