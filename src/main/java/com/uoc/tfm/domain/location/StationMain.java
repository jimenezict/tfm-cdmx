package com.uoc.tfm.domain.location;

public class StationMain {

    private int id;
    private String address;
    private StationLocation location;

    public StationMain() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StationLocation getLocation() {
        return location;
    }

    public void setLocation(StationLocation location) {
        this.location = location;
    }
}