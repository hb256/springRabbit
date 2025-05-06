package com.example.demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	private MessageProducer messageProducer;
	
	@GetMapping("/produce")
	public String produceMessage(@RequestParam String message) {
        messageProducer.produce(message);
		return "Sucess";
	}

}