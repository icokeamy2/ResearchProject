package com.algridashboard.dashboard.util;

public class JsonResult {
    private Object smallStats;
    private String msg;
    private Integer code;

    public Object getSmallStats() {
        return smallStats;
    }

    public void setSmallStats(Object obj) {
        this.smallStats = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
