package com.bank.notification.service;

import com.bank.notification.dto.NotificationRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailNotificationService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromAddr;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public static String getLastFourDigits(String accountNumber) {
        if (accountNumber != null && accountNumber.length() > 4) {
            return accountNumber.substring(accountNumber.length() - 4);
        } else {
            return accountNumber; // Return the full number if it's too short
        }
    }

    public String sendToBoth(NotificationRequest req) {
        // Send to sender
        SimpleMailMessage m1 = new SimpleMailMessage();
        m1.setFrom(fromAddr);
        m1.setTo(req.getSenderEmail());
        m1.setSubject("Payment Sent: ₹" + req.getAmount());
        m1.setText("Hi " + (req.getSenderName()!=null?req.getSenderName():"") +
                ",\n\nYou have successfully sent ₹" + req.getAmount() + " from Account : *****"+ getLastFourDigits(req.getSenderAccountNumber()) +
                " to " + (req.getReceiverName()!=null?req.getReceiverName():req.getReceiverEmail()) +
                ".\n\nThanks.");

        // Send to receiver
        SimpleMailMessage m2 = new SimpleMailMessage();
        m2.setFrom(fromAddr);
        m2.setTo(req.getReceiverEmail());
        m2.setSubject("Payment Received: ₹" + req.getAmount());
        m2.setText("Hi " + (req.getReceiverName()!=null?req.getReceiverName():"") +
                ",\n\nYou have received ₹" + req.getAmount() + " from Account : *****"+ getLastFourDigits(req.getReceiverAccountNumber()) +
                " from " + (req.getSenderName()!=null?req.getSenderName():req.getSenderEmail()) +
                ".\n\nThanks.");

        mailSender.send(m1);
        mailSender.send(m2);

        return "Emails sent";
    }
}
