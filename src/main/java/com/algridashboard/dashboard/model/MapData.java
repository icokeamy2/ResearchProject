package com.algridashboard.dashboard.model;

public class MapData {
    private String name;
    private location lo;

    public location getLo() {
        return lo;
    }

    public String getName() {
        return name;
    }

    public void setLo(location lo) {
        this.lo = lo;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAll(String name,location lo) {
        this.name = name;
        this.lo = lo;
    }
}
