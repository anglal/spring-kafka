package com.zlimbu.lal.springkakaconsumer.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(topics = "zlimbu", groupId = "group1")
	public void consume(String message) {
		
		LOGGER.info(String.format("Message received: %s", message));
	}
}
