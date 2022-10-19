package com.example.fabrickcontroller.service;

import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class TransactionService extends BaseService {
    private static final Logger log = (Logger) LoggerFactory.getLogger(TransactionService.class);
    private final String baseSlug = "";
    RestTemplate restTemplate;

}
