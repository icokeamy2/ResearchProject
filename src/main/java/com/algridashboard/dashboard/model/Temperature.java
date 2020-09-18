package com.algridashboard.dashboard.model;

public class Temperature {
    private String temp;

    private String time;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp == null ? null : temp.trim();

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", temp=").append(temp);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}