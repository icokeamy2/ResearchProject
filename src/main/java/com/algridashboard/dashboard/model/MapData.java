package com.algridashboard.dashboard.model;

public class MapData {
    private String name;
    private location location;

    public location getLo() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setLo(location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAll(String name,location location) {
        this.name = name;
        this.location = location;
    }
}
