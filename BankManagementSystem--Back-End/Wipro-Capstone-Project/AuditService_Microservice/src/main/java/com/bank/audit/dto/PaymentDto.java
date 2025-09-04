package com.bank.audit.dto;

import java.time.LocalDateTime;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
    private Long id;
    private String senderAccountNumber;
    private String senderEmail;
    private String senderName;
    private String receiverAccountNumber;
    private String receiverEmail;
    private String receiverName;
    private Double amount;
    private String status;
    private LocalDateTime createdAt;
}
