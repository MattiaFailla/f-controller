package com.example.fabrickcontroller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferAddressDto implements Serializable {
    private String address;
    private String city;
    private String countryCode;
}
