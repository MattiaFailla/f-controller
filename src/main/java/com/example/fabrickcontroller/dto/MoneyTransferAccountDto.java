package com.example.fabrickcontroller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferAccountDto implements Serializable {
    private String accountCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bicCode;
}
