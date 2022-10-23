package com.example.fabrickcontroller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferDomainDto {
    private MoneyTransferCreditorDto creditor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String executionDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uri;
    @Size(max = 140)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    private Double amount;
    private String currency;
    @JsonProperty("isUrgent")
    private Boolean isUrgent;
    @JsonProperty("isInstant")
    private Boolean isInstant;
    private feeTypeDto feeType;
    private String feeAccountId;
    private MoneyTransferTaxReliefDto taxRelief;
}
