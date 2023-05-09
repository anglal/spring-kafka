package com.zlimbu.lal.springkakaproducer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zlimbu.lal.springkakaproducer.kafka.KafkaProducer;

@RestController
@RequestMapping("/zlimbu")
public class MessageController {
	
	private KafkaProducer kafkaProducer;
	
	public MessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@GetMapping("/publish")
	
	// http://localhost:8080/zlimbu/publish?message=my first message
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		this.kafkaProducer.publishMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
		
	}
}
