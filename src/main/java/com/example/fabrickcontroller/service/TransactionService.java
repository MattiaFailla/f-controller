package com.example.fabrickcontroller.service;

import com.example.fabrickcontroller.dto.MoneyTransferDomainDto;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(TransactionService.class);
    final
    RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public @NotNull ResponseEntity<Object> triggerTransaction(String accountId, @NotNull MoneyTransferDomainDto moneyTransferDto) {
        String slug = baseSlug + "/" + accountId + "/payments/money-transfers";
        log.info("Triggering transaction for a total value of " + moneyTransferDto.getAmount() + " to " + moneyTransferDto.getCreditor());
        HttpEntity<MoneyTransferDomainDto> customRequestEntity = new HttpEntity<>(moneyTransferDto, generateHeaders().getHeaders());
        ResponseEntity<Object> response;
        try {
            response = restTemplate.exchange(slug, HttpMethod.POST, customRequestEntity, Object.class);
        } catch (HttpClientErrorException e) {
            log.error("Transaction could not be processed. " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getResponseBodyAsString());
        }
        return response;
    }
}
