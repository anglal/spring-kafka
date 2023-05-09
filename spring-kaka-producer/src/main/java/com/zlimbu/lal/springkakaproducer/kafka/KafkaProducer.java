package com.zlimbu.lal.springkakaproducer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final Logger  LOGGER = LoggerFactory.getLogger(Producer.class);
	
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publishMessage(String message) {
		this.kafkaTemplate.send("zlimbu", message);
		LOGGER.info(String.format("Message sent: %s",message));
	}
}
