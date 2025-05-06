package com.example.demo.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	   private final MessageProducer messageProducer;
	   
	   public MessageService(MessageProducer messageProducer) {
	       this.messageProducer = messageProducer;
	   }

	   public void produce(String messageContent) {
	       // Add any pre-publishing validation logic here.
	       // Example: Validate messageContent is not null or empty.

	       messageProducer.produce(messageContent);
	   }

	   // Optional: Retry mechanism (simplified)
	   public void produceWithRetry(String messageContent, int maxRetries) {
	       int retryCount = 0;
	       while (retryCount < maxRetries) {
	           try {
	        	   produce(messageContent);
	               return; // Success, exit the loop
	           } catch (Exception e) {
	               retryCount++;
	               // Implement a delay between retries (e.g., exponential backoff)
	               // System.out.println("Publish failed, retrying... " + retryCount + "/" + maxRetries);
	               // Thread.sleep(delayMilliseconds); // Add a delay
	           }
	       }
	   }
}
