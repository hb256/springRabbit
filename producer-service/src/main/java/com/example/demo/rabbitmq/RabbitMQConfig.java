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
	public MessageValidationService validationService() {
		return new MessageValidationService();
	};

	@Bean
	public Queue myQueue() {
		return new Queue(queueName, false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	@Bean
	public MessageProducer myProducer() {
		return new MessageProducer();
	}
//	 @Bean
//	    public Binding binding(Queue queue, TopicExchange exchange) {
//	        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//	    }
}
