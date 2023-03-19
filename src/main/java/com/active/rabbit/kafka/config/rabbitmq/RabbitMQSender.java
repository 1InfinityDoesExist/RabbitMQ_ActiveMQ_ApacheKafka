package com.active.rabbit.kafka.config.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RabbitMQSender {

	@Qualifier("rabbitMQTemplate")
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private RabbitMQProperties mqProperties;

	public void send(String msg) {
		log.info("-----Sending msg to the rabbitmq queue-----");
		try {
			rabbitTemplate.convertAndSend(mqProperties.getExchange(), mqProperties.getRoutingKey(), msg);
		} catch (AmqpException e) {
			log.error("-----Error : {}", e.getMessage());
			e.printStackTrace();
		}

	}
}
