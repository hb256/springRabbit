package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
public class RabbitMQConfig {
	 @Value("${spring.rabbitmq.queue}")
	    private String queueName;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    
	@Bean
	public Queue myQueue() {
		System.out.println("Q: " + queueName );
		return new Queue(queueName, false);
	}
}
