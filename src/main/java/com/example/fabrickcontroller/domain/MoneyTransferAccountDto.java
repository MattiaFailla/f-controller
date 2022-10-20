package com.example.fabrickcontroller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferAccountDto implements Serializable {
    private String accountCode;
    private String bicCode;
}
