package com.example.fabrickcontroller.controller;

import com.example.fabrickcontroller.dto.MoneyTransferDomainDto;
import com.example.fabrickcontroller.service.TransactionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f/transactions")
public class TransactionController {

    final
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{accountId}/create-transaction")
    public ResponseEntity<?> createMoneyTransfer(@PathVariable(name = "accountId") String accountId,
                                                 @RequestBody @NotNull MoneyTransferDomainDto moneyTransferDto) {
        return transactionService.triggerTransaction(accountId, moneyTransferDto);
    }

}
