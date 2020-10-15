package com.algridashboard.dashboard.model;

public class referralData {
    private String title;
    private String value;

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAll(String value,String title){
        this.value = value;
        this.title = title;
    }
}
