package com.bank.notification.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private String senderEmail;
    private String receiverEmail;
    private String senderName;
    private String receiverName;
    private Double amount;
    private String senderAccountNumber;
    private String receiverAccountNumber;

    public NotificationRequest() {}
}
