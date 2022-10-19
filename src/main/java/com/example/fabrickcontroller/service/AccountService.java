package com.example.fabrickcontroller.service;

import com.example.fabrickcontroller.domain.MaskBalanceDomain;
import com.example.fabrickcontroller.domain.MaskTransactionDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AccountService extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    private final String baseSlug = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts";
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Object> getAccounts() {
        ResponseEntity<Object> ResponseEntity = restTemplate.exchange(baseSlug, HttpMethod.GET, generateHeaders(), Object.class);
        return ResponseEntity;
    }

    public ResponseEntity<Object> getAccount(String accountId) {
        String slug = baseSlug + "/" + accountId;
        log.info("Requesting data from " + slug);
        return restTemplate.exchange(slug, HttpMethod.GET, generateHeaders(), Object.class);
    }

    public ResponseEntity<Object> getBalance0(String accountId) {
        String slug = baseSlug + "/" + accountId + "/balance";
        log.info("Retrieving account balance for the account " + accountId);
        return restTemplate.exchange(slug, HttpMethod.GET, generateHeaders(), Object.class);
    }

    public MaskBalanceDomain getBalance(String accountId) {
        String slug = baseSlug + "/" + accountId + "/balance";
        log.info("Retrieving account balance for the account " + accountId);
        ResponseEntity<MaskBalanceDomain> responseEntity = restTemplate.exchange(slug,
                HttpMethod.GET, generateHeaders(),
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
    }

    public MaskTransactionDomain getTransactions(String accountId,
                                                 String fromAccountingDate,
                                                 String toAccountingDate) {
        String slug = baseSlug + "/" + accountId + "/transactions";
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(slug)
                .queryParam("fromAccountingDate", fromAccountingDate)
                .queryParam("toAccountingDate", toAccountingDate)
                .encode()
                .toUriString();
        log.info("Retrieving the list of transactions for the account: " + accountId + "" +
                " from " + fromAccountingDate + " to " + toAccountingDate);
        ResponseEntity<MaskTransactionDomain> responseEntity = restTemplate.exchange(urlTemplate,
                HttpMethod.GET, generateHeaders(),
                new ParameterizedTypeReference<>() {
                }
        );
        MaskTransactionDomain transactions = responseEntity.getBody();
        if (transactions.getList() != null) {
            log.info(transactions.getList().toString());
        } else {
            log.error("Can't find any tx in the provided timeframe");
        }
        log.info("Updating internal db with the list of txs");
        return transactions;
    }


}
