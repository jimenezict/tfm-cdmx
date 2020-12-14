package com.uoc.tfm.controller;

import com.uoc.tfm.domain.cdmx.Token;
import com.uoc.tfm.service.ClientService;
import com.uoc.tfm.commons.domain.StationsLocation;
import com.uoc.tfm.commons.domain.StationsStatus;
import com.uoc.tfm.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControllerImpl implements ClientController {

    private static Logger log = LoggerFactory.getLogger(ClientControllerImpl.class);

    private static Token token;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenService service;

    @Override
    public StationsLocation getStationsLocation() {
        log.info("Starting station collections: {}", clientService.getServiceName());
        StationsLocation stationsLocation = new StationsLocation();

        try {
            stationsLocation = clientService.getStationsLocation();
        } catch(Exception e) {
            log.error("Fail on Location status collection {} due to: ", clientService.getServiceName(), e);
            return stationsLocation;
        }
            log.info("Ending station collections: {} with {} registers",
                clientService.getServiceName(),
                stationsLocation.getStationLocationList().size());
        return stationsLocation;

    }

    @Override
    @GetMapping("/status")
    public StationsStatus getStationStatus() {
        log.info("Starting station status collections: {}", clientService.getServiceName());
        StationsStatus stationStatus = new StationsStatus();

        try {
            stationStatus = clientService.getStationStatus();
        } catch(Exception e) {
            log.error("Fail on station status collection {} due to: ", clientService.getServiceName(), e);
            return stationStatus;
        }
        log.info("Ending station status collections: {} with {} registers",
                clientService.getServiceName(),
                stationStatus.getStationStatusList().size());
        return stationStatus;

    }
}
