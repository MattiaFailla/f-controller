package com.example.fabrickcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FabrickControllerApplication {

    private static final Logger log = LoggerFactory.getLogger(FabrickControllerApplication.class);
    public static void main(String[] args) {
        log.info("Client started..");
        SpringApplication.run(FabrickControllerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
