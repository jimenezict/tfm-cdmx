package com.uoc.tfm.domain.cdmx;

public class UrlManager {

    private static final String clientId = "2118_262orx37oz7ogwkw8o84gowwcsw04gkoos4oo8ks0ccoo8sww4";
    private static final String clientSecret = "2z1qya76idyck04oo0ok4ogw8s4k8cw8gs4koc88w08k4goksg";

    public static String tokenUrl() {
        return "https://pubsbapi-latam.smartbike.com/oauth/v2/token?" +
                "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=client_credentials";
    }

    public static String locationUrl(String accessToken) {
        return "https://pubsbapi-latam.smartbike.com/api/v1/stations.json?access_token=" + accessToken;
    }

    public static String stationUrl(String accessToken) {
        return "https://pubsbapi-latam.smartbike.com/api/v1/status.json?access_token=" + accessToken;
    }

}
