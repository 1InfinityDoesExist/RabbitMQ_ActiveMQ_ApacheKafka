package com.active.rabbit.kafka.kafkaProducerConfig;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer {

	public KafkaProducer() {
		log.info("----KafkaProducer Constructor-----");
	}

	@Qualifier("oauthKafkaTemplate")
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void publish(String topic, String payload) {
		ListenableFuture<SendResult<String, String>> sendResult = kafkaTemplate.send(topic,
				UUID.randomUUID().toString(), payload);
		sendResult.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("-----OnSuccess Callback : {}", result.getRecordMetadata());

				log.info(String.format("Produced:\ntopic: %s\noffset: %d\npartition: %d\nvalue size: %d",
						result.getRecordMetadata().topic(), 
						result.getRecordMetadata().offset(),
						result.getRecordMetadata().partition(), 
						result.getRecordMetadata().serializedValueSize()
				));
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("----OnFailure Callback : {}", ex.getMessage());
			}
		});
	}

}
