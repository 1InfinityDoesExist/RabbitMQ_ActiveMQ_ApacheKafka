package com.active.rabbit.kafka.config.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "rabbit.mq")
public class RabbitMQProperties {
	private String queue;
	private String exchange;
	private String routingKey;
	private String address;
	private int port;
	private String username;
	private String password;

}
