package com.example.fabrickcontroller.controller;

import com.example.fabrickcontroller.domain.MaskBalanceDomain;
import com.example.fabrickcontroller.domain.MaskTransactionListDomain;
import com.example.fabrickcontroller.service.AccountService;
import org.jetbrains.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/f/accounts")
public class AccountController {
    final
    AccountService accountService;

    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.CONFLICT,
            reason = "Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String conflict() {

        return "{\"status\":\"OK\",\"error\":[],\"payload\":{}";
    }

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<?> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable("accountId") String accountId) {
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
