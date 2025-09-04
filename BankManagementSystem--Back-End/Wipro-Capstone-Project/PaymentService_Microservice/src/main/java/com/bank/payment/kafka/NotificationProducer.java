package com.bank.payment.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bank.payment.dto.NotificationRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotificationProducer {

	private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;

	public void sendNotificationRequest(NotificationRequest request) {
		kafkaTemplate.send("notify-payment", request);
	}

}
