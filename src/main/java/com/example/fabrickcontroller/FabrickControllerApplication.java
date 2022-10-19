package com.example.fabrickcontroller;

import com.example.fabrickcontroller.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FabrickControllerApplication {

    private static final Logger log = LoggerFactory.getLogger(FabrickControllerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(FabrickControllerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Account account = restTemplate.getForObject(
                    "https://sandbox.platfr.io//api/gbs/banking/v4.0/accounts", Account.class
            );
                    log.info(account != null ? account.toString() : "Invalid account");
        };
    }

}
