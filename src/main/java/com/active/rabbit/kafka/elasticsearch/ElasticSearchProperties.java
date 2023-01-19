package com.active.rabbit.kafka.elasticsearch;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "oauth.elastic")
public class ElasticSearchProperties {
	private String elasticHost;
	private int elasticPort;

}
