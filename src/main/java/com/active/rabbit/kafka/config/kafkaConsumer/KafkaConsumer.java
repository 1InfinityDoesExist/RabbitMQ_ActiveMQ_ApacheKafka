package com.active.rabbit.kafka.config.kafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

	public KafkaConsumer() {
		log.info("-----KafkaConsumer constructor----");
	}

	@KafkaListener(topics = "${oauth.kafka.topic:payment}", groupId = "${oauth.kafka.groupId:payee}", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void receive(@Payload String msg, 
			final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
			final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			final @Header(KafkaHeaders.OFFSET) int offset,
			final @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts, 
			final @Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
			final @Header(KafkaHeaders.GROUP_ID) String groupId,
			Acknowledgment ack) {

		log.info(String.format(
				"#### -> Consumed message -> TIMESTAMP: %d\n%s\noffset: %d\nkey: %s\npartition: %d\ntopic: %s\ntimestampType: %s\nGroup-Id: %s", ts, msg,
				offset, key, partition, topic, timestampType, groupId));
		ack.acknowledge();
	}
}
