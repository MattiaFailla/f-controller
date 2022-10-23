package com.example.fabrickcontroller.service;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
@PropertySource("classpath:config.properties")
public class BaseService {
    @Value("${baseSlug}")
    String baseSlug;


    public @NotNull HttpEntity<Object> generateHeaders() {
        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.APPLICATION_JSON);
        head.add("Auth-Schema", "S2S");
        head.add("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        return new HttpEntity<>(head);
    }
}
