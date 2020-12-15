package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;

public interface TokenService {

    boolean isTokenActive();

    void generateNewToken();

}
