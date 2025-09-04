package com.bank.payment.service;

import com.bank.payment.dto.*;
import com.bank.payment.entity.Payment;
import com.bank.payment.feign.AccountClient;
import com.bank.payment.kafka.NotificationProducer;
//import com.bank.payment.feign.NotificationClient;
import com.bank.payment.repository.PaymentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final AccountClient accountClient;
    private final NotificationProducer producer;
//    private final NotificationClient notificationClient;

    public PaymentService(PaymentRepository repository,
                          AccountClient accountClient, NotificationProducer producer) {
        this.repository = repository;
        this.accountClient = accountClient;
        this.producer = producer;
//        this.notificationClient = notificationClient;
    }

    @Transactional
    public TransferResponse transfer(TransferRequest req) {
        Payment payment = new Payment();
        payment.setSenderAccountNumber(req.getFromAccountNumber());
        payment.setReceiverAccountNumber(req.getToAccountNumber());
        payment.setSenderEmail(req.getSenderEmail());
        payment.setReceiverEmail(req.getReceiverEmail());
        payment.setSenderName(req.getSenderName());
        payment.setReceiverName(req.getReceiverName());
        payment.setAmount(req.getAmount());
        payment.setStatus("INITIATED");
        payment = repository.save(payment);

        try {
            // 1) Debit source (choose method based on your AccountService contract)
            // using bank account numbers as example
            accountClient.debitByBankNumber(req.getFromAccountNumber(), req.getAmount());

            // 2) Credit target
            accountClient.creditByBankNumber(req.getToAccountNumber(), req.getAmount());

            // 3) persist success
            payment.setStatus("SUCCESS");
            repository.save(payment);

            // 4) notify both parties
            NotificationRequest notification = new NotificationRequest(
                    req.getSenderEmail(),
                    req.getReceiverEmail(),
                    req.getSenderName(),
                    req.getReceiverName(),
                    req.getAmount(),req.getFromAccountNumber(),req.getToAccountNumber()
            );
              producer.sendNotificationRequest(notification);
//            notificationClient.sendToBoth(notification);

            return new TransferResponse("SUCCESS", "Transfer completed", payment.getId());
        } catch (Exception ex) {
            // rollback behavior: since @Transactional, if account calls throw runtime exceptions, it will roll back DB
            payment.setStatus("FAILED");
            repository.save(payment);
            return new TransferResponse("FAILED", "Transfer failed: " + ex.getMessage(), payment.getId());
        }
    }

    public Payment getPaymentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public java.util.List<Payment> getAllPayments() {
        return repository.findAll();
    }
}
