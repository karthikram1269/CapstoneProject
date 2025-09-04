package com.bank.payment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we store accounts/emails/names for audit
    private String senderAccountNumber; // bank account or aadhar etc (optional)
    private String senderEmail;
    private String senderName;

    private String receiverAccountNumber;
    private String receiverEmail;
    private String receiverName;

    private Double amount;
    private String status; // SUCCESS, FAILED
    private LocalDateTime createdAt;

    public Payment() {}

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
