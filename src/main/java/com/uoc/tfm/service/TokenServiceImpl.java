package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static com.uoc.tfm.domain.cdmx.UrlManager.tokenUrl;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public boolean isTokenActive() {
        Token token = Token.getInstance();
        return nonNull(token)
                && nonNull(token.getAccess_token())
                && token.getExpiresDate().isAfter(LocalDateTime.now());
    }

    @Override
    public void generateNewToken() {
        RestTemplate restTemplate = new RestTemplate();
        Token token = restTemplate.getForObject(tokenUrl(), Token.class);

        Token.getInstance().setExpires_in(token.getExpires_in());
        Token.getInstance().setAccess_token(token.getAccess_token());
        Token.getInstance().setRefresh_token(token.getRefresh_token());
    }

}
