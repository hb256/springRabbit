package com.example.demo.rabbitmq;

public class MessageValidationService {
	public boolean isValid(String message) {
		return !message.isEmpty();
	}
	
}
