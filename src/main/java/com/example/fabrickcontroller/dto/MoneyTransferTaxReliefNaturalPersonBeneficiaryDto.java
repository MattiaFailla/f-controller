package com.example.fabrickcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransferTaxReliefNaturalPersonBeneficiaryDto implements Serializable {
    private String fiscalCode1;
    private String fiscalCode2;
    private String fiscalCode3;
    private String fiscalCode4;
    private String fiscalCode5;

}
