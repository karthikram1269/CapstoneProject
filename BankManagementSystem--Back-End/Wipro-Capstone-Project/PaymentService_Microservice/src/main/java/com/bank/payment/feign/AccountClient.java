package com.bank.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service", url = "http://localhost:8082/api/accounts")
public interface AccountClient {

    // example endpoints in AccountService — adapt if your AccountService uses different paths
    @PostMapping("/{accountId}/debit")
    void debitAccount(@PathVariable("accountId") Long accountId, @RequestParam("amount") Double amount);

    @PostMapping("/{accountId}/credit")
    void creditAccount(@PathVariable("accountId") Long accountId, @RequestParam("amount") Double amount);

    // or by bankAccountNumber
    @PostMapping("/bank/{bankNumber}/debit")
    void debitByBankNumber(@PathVariable("bankNumber") String bankNumber, @RequestParam("amount") Double amount);

    @PostMapping("/bank/{bankNumber}/credit")
    void creditByBankNumber(@PathVariable("bankNumber") String bankNumber, @RequestParam("amount") Double amount);
}
