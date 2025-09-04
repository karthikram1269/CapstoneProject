package com.bank.payment.dto;

import lombok.Data;

@Data
public class TransferResponse {
    private String status;
    private String message;
    private Long paymentId;

    public TransferResponse() {}
    public TransferResponse(String status, String message, Long paymentId) {
        this.status = status; this.message = message; this.paymentId = paymentId;
    }
}