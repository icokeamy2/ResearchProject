package com.algridashboard.dashboard.model;

public class WarningTable {
    private String id;

    private String date;
    private String status;

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setAll(String id,String date,String status){
        this.date = date;
        this.id = id;
        this.status = status;
    }
}
