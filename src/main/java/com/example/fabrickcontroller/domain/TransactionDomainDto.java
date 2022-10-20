package com.example.fabrickcontroller.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MapKey;
import java.io.Serializable;

/**
 * A DTO for the {@link TransactionDomain} entity
 */
@Data
public class TransactionDomainDto implements Serializable {
    @Id
    @MapKey
    private final String transactionId;
    private final String operationId;
    private final String accountingDate;
    private final String ValueDate;
    private final float amount;
    private final String currency;
    private final String description;
}