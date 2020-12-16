package com.uoc.tfm.domain.status;

public class StationStatus {

    private int id;
    private Availability availability;

    public StationStatus(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}