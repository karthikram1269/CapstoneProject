package com.bank.audit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "audit_records")
public class AuditRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long paymentId;
    private String fromAccount;
    private String toAccount;
    private String senderEmail;
    private String receiverEmail;
    private Double amount;
    private String status;
    private LocalDateTime recordedAt;

    @PrePersist
    public void pre() {
        recordedAt = LocalDateTime.now();
    }
}
