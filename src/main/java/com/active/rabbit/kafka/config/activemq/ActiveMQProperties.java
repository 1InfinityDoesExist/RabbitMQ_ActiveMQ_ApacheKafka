package com.active.rabbit.kafka.config.activemq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "active.mq")
public class ActiveMQProperties {
	private String brokerUrl;
	private String username;
	private String password;

}
