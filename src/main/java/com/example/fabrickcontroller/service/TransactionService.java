package com.example.fabrickcontroller.service;

import com.example.fabrickcontroller.domain.MoneyTransferDomainDto;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class TransactionService extends BaseService {
    private final Logger log = (Logger) LoggerFactory.getLogger(TransactionService.class);
    RestTemplate restTemplate;


    public ResponseEntity<Object> triggerTransaction(String accountId, MoneyTransferDomainDto moneyTransferDto) {
        String slug = baseSlug + "/" + accountId + "/payments/money-transfers";
        log.info("Triggering transaction for a total value of " + moneyTransferDto.getAmount() + " to " + moneyTransferDto.getCreditor());
        ResponseEntity<Object> response;
        try {
            response = restTemplate.exchange(slug, HttpMethod.GET, generateHeaders(), Object.class);
        } catch (HttpClientErrorException e) {
            log.info("Transaction could not be processed. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getResponseBodyAsString());
        }
        return response;
    }
}
