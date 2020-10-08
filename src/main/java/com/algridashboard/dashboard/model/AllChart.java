package com.algridashboard.dashboard.model;

public class AllChart {
    private String label;
    private String value;

    private String percentage;
    private Boolean increase;
    private Boolean decrease;
    private String[] chartLabels;
    private Datasets[] datasets;


public void setAll(String label,String value,String percentage,Boolean increase,Boolean decrease,String[] chartLabels,Datasets[] datasets){
    this.label=label;
    this.value = value;
    this.percentage = percentage;
    this.increase = increase;
    this.decrease = decrease;
    this.chartLabels = chartLabels;
    this.datasets = datasets;
}
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public void setIncrease(Boolean increase) {
        this.increase = increase;
    }

    public Boolean getIncrease() {
        return increase;
    }

    public void setDecrease(Boolean decrease) {
        this.decrease = decrease;
    }

    public Boolean getDecrease() {
        return decrease;
    }

    public void setChartLabels(String[] chartLabels) {
        this.chartLabels = chartLabels;
    }

    public String[] getChartLabels() {
        return chartLabels;
    }

    public Datasets[] getDatasets() {
        return datasets;
    }

    public void setDatasets(Datasets[] datasets) {
        this.datasets = datasets;
    }
}
