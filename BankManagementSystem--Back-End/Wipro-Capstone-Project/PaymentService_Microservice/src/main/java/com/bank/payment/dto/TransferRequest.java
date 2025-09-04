package com.bank.payment.dto;

import lombok.Data;

@Data
public class TransferRequest {
	
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;

    // Optionally include sender/receiver emails and names (if known)
    private String senderEmail;
    private String senderName;
    private String receiverEmail;
    private String receiverName;

}