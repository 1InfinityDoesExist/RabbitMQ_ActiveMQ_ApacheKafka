package com.active.rabbit.kafka.kafkaProducerConfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableKafka
@Configuration
@ConditionalOnProperty(prefix = "oauth.kafka", name = "enable", havingValue = "true")
public class ProducersConfig {

	@Autowired
	public ProducerProperties kafkaProperties;

	@Bean
	public Map<String, Object> kafkaProducerConfig() {
		log.info("----Setting kafka producer properties----- {}", kafkaProperties.getBootstarpServers());
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstarpServers());
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerialzier());
		properties.put(ProducerConfig.ACKS_CONFIG, kafkaProperties.getAcks());
		properties.put(ProducerConfig.RETRIES_CONFIG, kafkaProperties.getRetries());
		properties.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProperties.getBatchSize());
		properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProperties.getBufferMemory());
		log.info("----Properties of producer : {}", properties.toString());
		return properties;
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<String, String>(kafkaProducerConfig());
	}

	@Bean("oauthKafkaTemplate")
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(producerFactory());
	}

	@Bean("KafkaProducer")
	public KafkaProducer kakfKafkaProducer() {
		return new KafkaProducer();
	}

}
