package com.example.fabrickcontroller.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class BaseService {
    public HttpEntity<Object> generateHeaders() {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.APPLICATION_JSON);
        head.add("Auth-Schema", "S2S");
        head.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        return new HttpEntity<>(head);
    }
}
