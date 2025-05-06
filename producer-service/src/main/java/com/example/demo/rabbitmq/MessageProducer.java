package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;

	@Autowired
	private MessageValidationService validationService;


	public void produce(String message) {
		if (!validationService.isValid(message)) {
			throw new IllegalArgumentException("Invalid mesage: " + message);
		}
		Message validMessage = MessageBuilder.withBody(message.getBytes()).build();

		this.template.convertAndSend(queue.getName(), validMessage);
		System.out.println(" [x] Sent '" + new String(validMessage.getBody()) + "'");
	}
}
