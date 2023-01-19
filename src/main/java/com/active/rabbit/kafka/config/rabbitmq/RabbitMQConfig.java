package com.active.rabbit.kafka.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableRabbit
@Configuration
@ConditionalOnProperty(prefix = "rabbit.mq", name = "enable", havingValue = "true")
public class RabbitMQConfig {

	@Autowired
	private RabbitMQProperties rabbitMQProperties;

	@Bean
	public Queue queue() {
		log.info("----Queue : {}", rabbitMQProperties.getQueue());
		return new Queue(rabbitMQProperties.getQueue(), true);
	}

	@Bean
	public Exchange exchange() {
		log.info("-----Exchange :{}", rabbitMQProperties.getExchange());
		return new DirectExchange(rabbitMQProperties.getExchange());
	}

	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		log.info("----RoutingKey : {}", rabbitMQProperties.getRoutingKey());
		return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getRoutingKey());
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(rabbitMQProperties.getAddress());
		connectionFactory.setPort(rabbitMQProperties.getPort());
		connectionFactory.setPassword(rabbitMQProperties.getPassword());
		connectionFactory.setUsername(rabbitMQProperties.getUsername());
		return connectionFactory;
	}

	@Bean("rabbitMQTemplate")
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setMessageConverter(jsonMessageConverter());
		return template;
	}

}
