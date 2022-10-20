package com.example.fabrickcontroller.controller;

import com.example.fabrickcontroller.domain.MoneyTransferDomainDto;
import com.example.fabrickcontroller.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/{accountId}/create-transaction")
    public ResponseEntity<Object> createMoneyTransfer(@PathVariable(name = "accountId") String accountId,
                                                      @RequestBody MoneyTransferDomainDto moneyTransferDto) {
        return transactionService.triggerTransaction(accountId, moneyTransferDto);
    }

}
