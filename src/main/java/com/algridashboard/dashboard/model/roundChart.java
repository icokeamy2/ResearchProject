package com.algridashboard.dashboard.model;

public class roundChart {
    private String[] labels;
    private roundDataSet rounddata;

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public void setRounddata(roundDataSet rounddata) {
        this.rounddata = rounddata;
    }
    public void setAll(String[] labels,roundDataSet rounddata) {
        this.labels = labels;
        this.rounddata = rounddata;
    }
}
