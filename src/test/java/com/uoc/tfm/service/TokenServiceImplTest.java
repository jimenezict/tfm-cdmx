package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenServiceImplTest {

    TokenServiceImpl tokenService = new TokenServiceImpl();

    @Test
    public void isTokenActive_whenTokenIsNull() {
        assertFalse(tokenService.isTokenActive(null));
    }

    @Test
    public void isTokenActive_whenTokenIsNotNull_andExpiresInThePass() {
        Token token = new Token();
        token.setExpires_in(-1);
        assertFalse(tokenService.isTokenActive(token));
    }

    @Test
    public void isTokenActive_whenTokenIsNotNull_andExpiresInTheFuture() {
        Token token = new Token();
        token.setExpires_in(1);
        assertTrue(tokenService.isTokenActive(token));
    }

}