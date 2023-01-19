//package com.active.rabbit.kafka.config.rabbitmq;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class RabbitMQReceiver {
//
//	@RabbitListener(queues = "rabbit.queue")
//	public void receviceMsg(String msg) {
//		log.info("-----Listening to the rabbit queue-----msg:  {}", msg);
//
//	}
//
//}
