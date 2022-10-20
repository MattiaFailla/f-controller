package com.example.fabrickcontroller.dto;

import com.example.fabrickcontroller.domain.TransactionDomain;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

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
    private final @NotNull String transactionId;
    private final @NotNull String operationId;
    private final @NotNull String accountingDate;
    private final @NotNull String ValueDate;
    private final float amount;
    private final @NotNull String currency;
    private final @NotNull String description;
}