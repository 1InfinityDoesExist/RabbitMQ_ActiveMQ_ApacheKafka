//package com.active.rabbit.kafka.config.activemq;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
//import org.springframework.jms.support.converter.MessageConverter;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@EnableJms
//@Configuration
//@ConditionalOnProperty(prefix = "active.mq", name = "enable", havingValue = "true")
//public class ActiveMQConfig {
//
//	@Autowired
//	private ActiveMQProperties activeMQProperties;
//
//	@Bean
//	public ActiveMQConnectionFactory activeMQConnectionFactory() {
//		log.info("-----Creating connection factory bean-----");
//		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//		log.info("----URL : {} , userName : {} and passowrd : {}", activeMQProperties.getBrokerUrl(),
//				activeMQProperties.getUsername(), activeMQProperties.getPassword());
//		connectionFactory.setBrokerURL(activeMQProperties.getBrokerUrl());
//		connectionFactory.setUserName(activeMQProperties.getUsername());
//		connectionFactory.setPassword(activeMQProperties.getPassword());
//		return connectionFactory;
//	}
//
//	@Bean("ActiveMQJmsTemplate")
//	public JmsTemplate jmsTemplate() {
//		log.info("----JmsTemplate bean creation-----");
//		JmsTemplate template = new JmsTemplate();
//		template.setConnectionFactory(activeMQConnectionFactory());
////		template.setPubSubDomain(true); //Used for topic not for queue
//		template.setMessageConverter(jacksonJmsMessageConverter());
//		return template;
//	}
//
//	@Bean
//	public MessageConverter jacksonJmsMessageConverter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
////		converter.setTargetType(MessageType.TEXT);
////		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}
//
//	@Bean
//	public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
//		log.info("-----DefaultContainerFactory bean creation------");
//		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
//		containerFactory.setConnectionFactory(activeMQConnectionFactory());
////		containerFactory.setPubSubDomain(true);//Used for topic not for queue
//		containerFactory.setConcurrency("1-1");
//		return containerFactory;
//	}
//
//}
