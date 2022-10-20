package com.example.fabrickcontroller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferDomainDto {
    private MoneyTransferCreditorDto creditor;
    private String executionDate;
    private String uri;
    private String description;
    private float amount;
    private String currency;
    private boolean isUrgent;
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private MoneyTransferTaxReliefDto taxRelief;
}
