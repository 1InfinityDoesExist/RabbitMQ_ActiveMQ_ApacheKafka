//package com.active.rabbit.kafka.config.activemq;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class ActiveMQSender {
//
//	@Value("${active.mq.queue}")
//	private String queue;
//
//	@Autowired
//	@Qualifier("ActiveMQJmsTemplate")
//	private JmsTemplate jmsTemplate;
//
//	public void send(final String msg) {
//		log.info("----Sending msg : {} to queue : {}", msg, queue);
//		jmsTemplate.send(queue, new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				TextMessage textMessage = session.createTextMessage(msg);
//				log.info("----Final msg sent to the queue : {}", textMessage);
//				return textMessage;
//			}
//		});
//	}
//
//}
