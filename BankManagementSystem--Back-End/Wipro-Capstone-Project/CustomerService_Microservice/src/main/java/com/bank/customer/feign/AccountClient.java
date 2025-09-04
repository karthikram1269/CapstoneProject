package com.bank.customer.feign;

import com.bank.customer.dto.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", url = "http://localhost:8082/api/accounts")
public interface AccountClient {

    @GetMapping("/bank/{bankNumber}")
    AccountResponse getAccountByBankNumber(@PathVariable("bankNumber") String bankNumber);

    @GetMapping("/aadhar/{aadhar}")
    AccountResponse getAccountByAadhar(@PathVariable("aadhar") String aadhar);
}
