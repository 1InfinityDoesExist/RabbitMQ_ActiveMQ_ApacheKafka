package com.active.rabbit.kafka.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "oauth.redis")
public class RedisProperties {
	private String redisHost;
	private int redisPort;

}
