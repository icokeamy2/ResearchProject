package com.algridashboard.dashboard.model;

public class location {
    private Double lat;
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
    public void setAll(Double lat,Double lng) {
        this.lng = lng;
        this.lat = lat;
    }
}
