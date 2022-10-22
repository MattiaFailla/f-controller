package com.example.fabrickcontroller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferTaxReliefDto implements Serializable {
    private String taxReliefId;
    @JsonProperty("isCondoUpgrade")
    private Boolean isCondoUpgrade;
    private String creditorFiscalCode;
    private BeneficiaryTypeDto beneficiaryType;
    private MoneyTransferTaxReliefNaturalPersonBeneficiaryDto naturalPersonBeneficiary;
    private MoneyTransferTaxReliefLegalPersonBeneficiaryDto legalPersonBeneficiary;
}
