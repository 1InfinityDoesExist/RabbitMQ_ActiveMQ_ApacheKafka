package com.active.rabbit.kafka.config.kafkaConsumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "oauth.kafka.consumer")
public class ConsumerProperties {
	private String bootstrapServers;
	private String groupId;
	private String autoOffsetReset;
	private String keyDeserializer;
	private String valueDeserializer;
	private String enableAutoCommit;
	private String autoCommitInterval;
	private String sessionTimeout;
	private int concurrency;
	private int timeout;
	private int poolSize;
}
