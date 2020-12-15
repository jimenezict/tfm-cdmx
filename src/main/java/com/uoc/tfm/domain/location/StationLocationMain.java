package com.uoc.tfm.domain.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StationLocationMain {

    private List<StationMain> stations;

    public StationLocationMain() {

    }

    public List<StationMain> getStations() {
        return stations;
    }

    public void setStations(List<StationMain> stations) {
        this.stations = stations;
    }
}