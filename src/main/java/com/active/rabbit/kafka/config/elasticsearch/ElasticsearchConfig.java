package com.active.rabbit.kafka.config.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "oauth.elastic", name = "enable", havingValue = "true")
public class ElasticsearchConfig {

	@Autowired
	private ElasticSearchProperties elasticSearchProperties;

	@Bean
	public RestHighLevelClient resiHighLevelClient() {
		log.info("-----Creating elastic search bean----");
		RestHighLevelClient restClient = new RestHighLevelClient(
				RestClient.builder(new HttpHost(elasticSearchProperties.getElasticHost(),
						elasticSearchProperties.getElasticPort(), HttpHost.DEFAULT_SCHEME_NAME)));
		return restClient;
	}
}
