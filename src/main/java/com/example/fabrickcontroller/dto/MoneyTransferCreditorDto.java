package com.example.fabrickcontroller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyTransferCreditorDto implements Serializable {
    @Size(max = 70)
    private String name;
    private MoneyTransferAccountDto account;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MoneyTransferAddressDto address;
}
