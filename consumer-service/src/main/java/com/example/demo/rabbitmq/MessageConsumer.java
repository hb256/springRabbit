package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.AMQP.Queue;

@Service
public class MessageConsumer {

	@RabbitListener(queues =  "${spring.rabbitmq.queue}")
	public void receiveMessage(String message) {
		System.out.println("Received message: " + message);
	}
}
