package com.algridashboard.dashboard.model;

public class SessionChart {
    private String[] labels;

    private SessionDataset[] datasets;


    public void setAll(String[] labels,SessionDataset[] datasets){
        this.labels=labels;
        this.datasets = datasets;
    }

    public void setDatasets(SessionDataset[] datasets) {
        this.datasets = datasets;
    }

    public SessionDataset[] getDatasets() {
        return datasets;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }
}
