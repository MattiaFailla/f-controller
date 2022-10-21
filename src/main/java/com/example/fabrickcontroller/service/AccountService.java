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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    public @NotNull ResponseEntity<Object> getAccounts() {
        return restTemplate.exchange(baseSlug, HttpMethod.GET, generateHeaders(), Object.class);
    }

    public @NotNull ResponseEntity<Object> getAccount(String accountId) {
        String slug = baseSlug + "/" + accountId;
        log.info("Requesting data from " + slug);
        return restTemplate.exchange(slug, HttpMethod.GET, generateHeaders(), Object.class);
    }

    public @Nullable MaskBalanceDomain getBalance(String accountId) {
        String slug = baseSlug + "/" + accountId + "/balance";
        log.info("Retrieving account balance for the account " + accountId);
        ResponseEntity<MaskBalanceDomain> responseEntity = restTemplate.exchange(slug,
                HttpMethod.GET, generateHeaders(),
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity.getBody();
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
    }


}
