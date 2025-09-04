package com.bank.audit.service;

import com.bank.audit.dto.PaymentDto;
import com.bank.audit.entity.AuditRecord;
import com.bank.audit.feign.PaymentClient;
import com.bank.audit.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditService {

    private final PaymentClient paymentClient;
    private final AuditRepository auditRepository;

    public AuditService(PaymentClient paymentClient, AuditRepository auditRepository) {
        this.paymentClient = paymentClient;
        this.auditRepository = auditRepository;
    }

    public List<AuditRecord> syncPaymentsToAudit() {
        List<PaymentDto> payments = paymentClient.getAllPayments();
        List<AuditRecord> records = payments.stream().map(p -> {
            AuditRecord r = new AuditRecord();
            r.setPaymentId(p.getId());
            r.setFromAccount(p.getSenderAccountNumber());
            r.setToAccount(p.getReceiverAccountNumber());
            r.setSenderEmail(p.getSenderEmail());
            r.setReceiverEmail(p.getReceiverEmail());
            r.setAmount(p.getAmount());
            r.setStatus(p.getStatus());
            return r;
        }).collect(Collectors.toList());

        return auditRepository.saveAll(records);
    }

    public List<AuditRecord> getAllAuditRecords() {
        return auditRepository.findAll();
    }
}
