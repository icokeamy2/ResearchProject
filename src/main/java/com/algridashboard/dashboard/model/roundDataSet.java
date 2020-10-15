package com.algridashboard.dashboard.model;

public class roundDataSet {
    private String hoverBorderColor="rgba(255,255,255,1)";
    private Double[] data;
    private String[] icons={};
    private  String[] backgroundColor={"rgba(0,123,255,0.9)", "rgba(0,123,255,0.5)", "rgba(0,123,255,0.3)"};

    public void setData(Double[] data) {
        this.data = data;
    }

    public String[] getIcons() {
        return icons;
    }

    public void setIcons(String[] icons) {
        this.icons = icons;
    }

    public void setHoverBorderColor(String hoverBorderColor) {
        this.hoverBorderColor = hoverBorderColor;
    }

    public void setBackgroundColor(String[] backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Double[] getData() {
        return data;
    }

    public String[] getBackgroundColor() {
        return backgroundColor;
    }

    public String getHoverBorderColor() {
        return hoverBorderColor;
    }
}
