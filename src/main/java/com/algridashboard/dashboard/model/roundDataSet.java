package com.algridashboard.dashboard.model;

public class roundDataSet {
    private String hoverBorderColor="rgba(255,255,255,1)";
    private Double[] data;
    private String[] icons;
    private  String[] backgroundColor={"rgba(0,123,255,0.9)", "rgba(0,123,255,0.5)", "rgba(0,123,255,0.3)"};

    public void setData(Double[] data) {
        this.data = data;
    }

    public void setBackgroundColor(String[] backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
