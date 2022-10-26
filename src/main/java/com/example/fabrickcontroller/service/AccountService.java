package com.example.fabrickcontroller.service;

import com.example.fabrickcontroller.domain.MaskBalanceDomain;
import com.example.fabrickcontroller.domain.MaskTransactionListDomain;
import com.example.fabrickcontroller.domain.TransactionDomain;
import com.example.fabrickcontroller.repository.TransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class AccountService extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    final
    TransactionRepository transactionRepository;
    final
    RestTemplate restTemplate;

    public AccountService(TransactionRepository transactionRepository, RestTemplate restTemplate) {
        this.transactionRepository = transactionRepository;
        this.restTemplate = restTemplate;
    }

    public @NotNull ResponseEntity<?> getAccounts() {
        try {
            return restTemplate.exchange(baseSlug, HttpMethod.GET, generateHeaders(), Object.class);
        } catch (HttpClientErrorException e) {
            log.error("Unable to get the list of accounts..");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getResponseBodyAsString());
        }
    }

    public @NotNull ResponseEntity<?> getAccount(String accountId) {
        String slug = baseSlug + "/" + accountId;
        log.info("Requesting data from " + slug);
        try {
            return restTemplate.exchange(slug, HttpMethod.GET, generateHeaders(), Object.class);
        } catch (HttpClientErrorException e) {
            log.error("Unable to retrieve the provided account: " + e.getResponseBodyAsString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getResponseBodyAsString());
        }
    }

    public @Nullable MaskBalanceDomain getBalance(String accountId) {
        String slug = baseSlug + "/" + accountId + "/balance";
        log.info("Retrieving account balance for the account " + accountId);
        try {
            ResponseEntity<MaskBalanceDomain> responseEntity = restTemplate.exchange(slug,
                    HttpMethod.GET, generateHeaders(),
                    new ParameterizedTypeReference<>() {
                    }
            );
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            log.error("Unable to retrieve the balance: " + e.getResponseBodyAsString());
            MaskBalanceDomain responseEntity = new MaskBalanceDomain();
            responseEntity.setStatus("KO");
            responseEntity.setPayload(null);
            responseEntity.setError(Collections.singletonList(e.getResponseBodyAsString()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseEntity).getBody();
        }
    }

    public @Nullable MaskTransactionListDomain getTransactions(String accountId,
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
        try {
            ResponseEntity<MaskTransactionListDomain> responseEntity = restTemplate.exchange(urlTemplate,
                    HttpMethod.GET, generateHeaders(),
                    new ParameterizedTypeReference<>() {
                    }
            );
            MaskTransactionListDomain responseEntityBody = responseEntity.getBody();
            List<TransactionDomain> txs;
            if (responseEntityBody != null) {
                txs = responseEntityBody.getPayload().getList();
                log.info("Updating internal db with the list of txs");
                transactionRepository.saveAll(txs);
            } else {
                log.error("No valid transactions found in the provided dataframe for the specified account");
            }
            return responseEntityBody;
        } catch (HttpClientErrorException e) {
            log.error("Could not get the list of transactions: " + e.getResponseBodyAsString());
            MaskTransactionListDomain responseEntityBody = new MaskTransactionListDomain();
            responseEntityBody.setError(Collections.singletonList(e.getResponseBodyAsString()));
            responseEntityBody.setStatus("KO");
            responseEntityBody.setPayload(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseEntityBody).getBody();
        }
    }


}
