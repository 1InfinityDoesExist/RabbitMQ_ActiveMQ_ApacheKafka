package com.active.rabbit.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.active.rabbit.kafka.config.activemq.ActiveMQSender;

@RestController
@RequestMapping("/test")
public class DummyController {

//	@Autowired
//	private RabbitMQSender mqSender;

	@Autowired
	private ActiveMQSender activeMQSender;

//	@GetMapping("/rabbit-mq")
//	public ResponseEntity sendMsgToRabbitMQ() {
//		String msg = "{\"id\":1,\"title\":\"iPhone 9\",\"description\":\"An apple mobile which is nothing like apple\",\"price\":549,\"discountPercentage\":12.96,\"rating\":4.69,\"stock\":94,\"brand\":\"Apple\",\"category\":\"smartphones\",\"thumbnail\":\"https://i.dummyjson.com/data/products/1/thumbnail.jpg\",\"images\":[\"https://i.dummyjson.com/data/products/1/1.jpg\",\"https://i.dummyjson.com/data/products/1/2.jpg\",\"https://i.dummyjson.com/data/products/1/3.jpg\",\"https://i.dummyjson.com/data/products/1/4.jpg\",\"https://i.dummyjson.com/data/products/1/thumbnail.jpg\"]}";
//		mqSender.send(msg);
//		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("msg", "Success"));
//	}

	@GetMapping("/active-mq")
	public ResponseEntity sendMsgToRabbitMQ() {
		String msg = "{\"id\":1,\"title\":\"iPhone 9\",\"description\":\"An apple mobile which is nothing like apple\",\"price\":549,\"discountPercentage\":12.96,\"rating\":4.69,\"stock\":94,\"brand\":\"Apple\",\"category\":\"smartphones\",\"thumbnail\":\"https://i.dummyjson.com/data/products/1/thumbnail.jpg\",\"images\":[\"https://i.dummyjson.com/data/products/1/1.jpg\",\"https://i.dummyjson.com/data/products/1/2.jpg\",\"https://i.dummyjson.com/data/products/1/3.jpg\",\"https://i.dummyjson.com/data/products/1/4.jpg\",\"https://i.dummyjson.com/data/products/1/thumbnail.jpg\"]}";
		activeMQSender.send(msg);
		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("msg", "Success"));
	}
}
