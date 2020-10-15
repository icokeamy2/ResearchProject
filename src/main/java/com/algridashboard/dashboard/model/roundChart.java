package com.algridashboard.dashboard.model;

import java.util.ArrayList;

public class roundChart {
    private String[] labels;
    private ArrayList<roundDataSet> datasets;

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public void setRounddata(ArrayList<roundDataSet> datasets) {
        this.datasets = datasets;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setDatasets(ArrayList<roundDataSet> datasets) {
        this.datasets = datasets;
    }

    public ArrayList<roundDataSet> getDatasets() {
        return datasets;
    }

    public void setAll(String[] labels, ArrayList<roundDataSet> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
