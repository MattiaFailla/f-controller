package com.example.fabrickcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Double amount;
    private String currency;
    @JsonProperty("isUrgent")
    private Boolean isUrgent;
    @JsonProperty("isInstant")
    private Boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private MoneyTransferTaxReliefDto taxRelief;
}
