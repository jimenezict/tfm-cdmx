package com.uoc.tfm.domain.cdmx;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Token {

    private String access_token;
    private int expires_in;
    private String refresh_token;
    private LocalDateTime expiresDate;

    public Token() {
        expiresDate = LocalDateTime.now();
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        expiresDate = expiresDate.plus(expires_in, SECONDS);
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public LocalDateTime getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(LocalDateTime expiresDate) {
        this.expiresDate = expiresDate;
    }
}
