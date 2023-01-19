package com.active.rabbit.kafka.config.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActiveMQReceiver {

	@JmsListener(destination = "active.queue")
//	@SendTo("active.queue")
	public void receciveMsg(Message message) throws JMSException {
		log.info("-----Received msg from the queue-----");
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			String msg = textMessage.getText();
			log.info("----Final msg received : {}", msg);
		}
	}
}
