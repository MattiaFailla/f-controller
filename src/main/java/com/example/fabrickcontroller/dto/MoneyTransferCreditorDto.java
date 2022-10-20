package com.example.fabrickcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferCreditorDto implements Serializable {
    private String name;
    private MoneyTransferAccountDto account;
    private MoneyTransferAddressDto address;
}
