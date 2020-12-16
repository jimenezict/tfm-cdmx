package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;
import com.uoc.tfm.domain.location.StationLocationMain;
import com.uoc.tfm.domain.status.StationStatusMain;
import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.uoc.tfm.domain.cdmx.UrlManager.locationUrl;
import static com.uoc.tfm.domain.cdmx.UrlManager.stationUrl;
import static java.time.LocalDateTime.now;

@Service
public class ClientServiceImpl implements ClientService {

    @Value("${service.name:default}")
    private String serviceName;

    @Autowired
    private TokenService tokenService;

    private static Token token;

    @Override
    public StationsLocation getStationsLocation() {
        generateToken();
        RestTemplate restTemplate = new RestTemplate();
        StationLocationMain stationLocation =
                restTemplate.getForObject(
                        locationUrl(Token.getInstance().getAccess_token()),
                        StationLocationMain.class);
        return mapStationsLocation(stationLocation);
    }

    @Override
    public StationsStatus getStationStatus() {
        generateToken();
        RestTemplate restTemplate = new RestTemplate();
        StationStatusMain stationStatusMain =
                restTemplate.getForObject(
                        stationUrl(Token.getInstance().getAccess_token()),
                        StationStatusMain.class);
        return mapStationsStatus(stationStatusMain);
    }

    private void generateToken() {
        if(!tokenService.isTokenActive()) {
            tokenService.generateNewToken();
        }
    }

    private StationsStatus mapStationsStatus(StationStatusMain stationStatus) {
        StationsStatus stationsStatus = new StationsStatus(now());

        stationStatus.getStationsStatus().forEach(x -> {
            int size = x.getAvailability().getBikes() + x.getAvailability().getSlots();
            stationsStatus.addStation(
                    x.getId(),
                    size,
                    x.getAvailability().getBikes());
        });

        return stationsStatus;
    }

    private StationsLocation mapStationsLocation(StationLocationMain stationLocation) {
        StationsLocation stationsLocation = new StationsLocation(LocalDate.now());

        stationLocation.getStations().forEach(x -> {
            stationsLocation.addStation(
                    x.getId(),
                    x.getLocation().getLat(),
                    x.getLocation().getLon(),
                    x.getAddress());
        });

        return stationsLocation;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }
}
