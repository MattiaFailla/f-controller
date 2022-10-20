package com.example.fabrickcontroller.controller;

import com.example.fabrickcontroller.dto.MoneyTransferDomainDto;
import com.example.fabrickcontroller.service.TransactionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/{accountId}/create-transaction")
    public @NotNull ResponseEntity<Object> createMoneyTransfer(@PathVariable(name = "accountId") String accountId,
                                                               @RequestBody @NotNull MoneyTransferDomainDto moneyTransferDto) {
        return transactionService.triggerTransaction(accountId, moneyTransferDto);
    }

}
