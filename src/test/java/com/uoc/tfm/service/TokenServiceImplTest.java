package com.uoc.tfm.service;

import com.uoc.tfm.domain.cdmx.Token;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenServiceImplTest {

    TokenServiceImpl tokenService = new TokenServiceImpl();

    @Test
    public void isTokenActive_whenTokenIsNull() {
        assertFalse(tokenService.isTokenActive());
    }

    @Test
    public void isTokenActive_whenTokenIsNotNull_andExpiresInThePass() {
        Token token = Token.getInstance();
        token.setExpires_in(-1);
        assertFalse(tokenService.isTokenActive());
    }

    @Test
    public void isTokenActive_whenTokenIsNotNull_andExpiresInTheFuture() {
        Token token = Token.getInstance();
        token.setAccess_token("asdf");
        token.setExpires_in(1000);
        assertTrue(tokenService.isTokenActive());
    }

    @Test
    public void generateNewToken_shouldReturnToken_withAccessToken() {
        tokenService.generateNewToken();
        assertTrue(Token.getInstance().getAccess_token().length() > 10);
    }

}