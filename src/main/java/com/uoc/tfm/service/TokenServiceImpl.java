package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static java.time.LocalDate.now;
import static java.util.Objects.isNull;

public class TokenServiceImpl implements TokenService {

    private final String urlToken = "https://api.bsmsa.eu/ext/api/bsm/gbfs/v2/en/station_status";

    @Override
    public boolean isTokenActive(Token token) {
        return !(isNull(token) || token.getExpiresDate().isBefore(LocalDateTime.now()));
    }

    @Override
    public Token generateNewToken() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(urlToken, Token.class);
    }
}
