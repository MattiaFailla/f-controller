package com.example.fabrickcontroller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferTaxReliefDto implements Serializable {
    private String taxReliefId;
    private boolean isCondoUpgrade;
    private String creditorFiscalCode;
    private String beneficiaryType;
    private MoneyTransferTaxReliefNaturalPersonBeneficiaryDto naturalPersonBeneficiary;
    private MoneyTransferTaxReliefLegalPersonBeneficiaryDto legalPersonBeneficiary;
}
