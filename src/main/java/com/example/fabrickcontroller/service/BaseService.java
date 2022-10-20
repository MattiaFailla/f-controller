package com.example.fabrickcontroller.service;


import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class BaseService {
    final String baseSlug = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts";

    public @NotNull HttpEntity<Object> generateHeaders() {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.APPLICATION_JSON);
        head.add("Auth-Schema", "S2S");
        head.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        return new HttpEntity<>(head);
    }
}
