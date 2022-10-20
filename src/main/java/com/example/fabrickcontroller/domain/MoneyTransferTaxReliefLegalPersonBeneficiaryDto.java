package com.example.fabrickcontroller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferTaxReliefLegalPersonBeneficiaryDto implements Serializable {
    private String fiscalCode;
    private String legalRepresentativeFiscalCode;
}
