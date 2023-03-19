package com.active.rabbit.kafka.config.kafkaProducer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "oauth.kafka.producer")
public class ProducerProperties {
	private String bootstarpServers;
	private String keySerializer;
	private String valueSerialzier;
	private String acks;
	private String retries;
	private String batchSize;
	private String bufferMemory;

}
