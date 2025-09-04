package com.bank.audit.feign;

import com.bank.audit.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "payment-service", url = "http://localhost:8084/api/payments")
public interface PaymentClient {

    @GetMapping
    List<PaymentDto> getAllPayments();

    @GetMapping("/{id}")
    PaymentDto getPaymentById(@PathVariable("id") Long id);
}
