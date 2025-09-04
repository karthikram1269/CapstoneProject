package com.bank.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationRequest {
	
	
    private String senderEmail;
    private String receiverEmail;
    private String senderName;
    private String receiverName;
    private Double amount;   
    private String senderAccountNumber;
    private String receiverAccountNumber;

    
}
