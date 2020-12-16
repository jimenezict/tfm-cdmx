package com.uoc.tfm.domain.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationStatusMain {

    private List<StationStatus> stationsStatus;

    public StationStatusMain(){

    }

    public List<StationStatus> getStationsStatus() {
        return stationsStatus;
    }

    public void setStationsStatus(List<StationStatus> stationsStatus) {
        this.stationsStatus = stationsStatus;
    }

}