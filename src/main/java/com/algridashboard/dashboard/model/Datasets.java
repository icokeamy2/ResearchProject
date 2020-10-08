package com.algridashboard.dashboard.model;

public class Datasets {
    private String label;
    private String fill;

    private Integer[] data;
    private  String backgroundColor;
    private  String borderColor;
    private  Double borderWidth;

public void setAll(Integer[] data,String label,String fill,String backgroundColor,String borderColor){

    this.data = data;
    this.label = label;
    this.fill = fill;
    this.borderWidth=1.5;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
}
    public Integer[] getData() {
        return data;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
