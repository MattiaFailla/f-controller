package com.example.fabrickcontroller.controller;

import com.example.fabrickcontroller.domain.MaskBalanceDomain;
import com.example.fabrickcontroller.domain.MaskTransactionListDomain;
import com.example.fabrickcontroller.service.AccountService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping()
    public @NotNull ResponseEntity<Object> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public @NotNull ResponseEntity<Object> getAccount(@PathVariable("accountId") String accountId) {
        return accountService.getAccount(accountId);
    }

    @GetMapping("{accountId}/balance")
    public @Nullable MaskBalanceDomain getBalance(@PathVariable("accountId") String accountId) {
        return accountService.getBalance(accountId);
    }

    @GetMapping("{accountId}/transactions")
    public @Nullable MaskTransactionListDomain getTransactions(@PathVariable("accountId") String accountId,
                                                               @RequestParam("fromAccountingDate") String fromAccountingDate,
                                                               @RequestParam("toAccountingDate") String toAccountingDate) {
        return accountService.getTransactions(accountId, fromAccountingDate, toAccountingDate);
    }


}
