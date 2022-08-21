package com.truongtv14.RabbitMQ.configuration.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void senderMessage() {
		RabbitMQMessageSender rabbitMQMessageSender = new RabbitMQMessageSender();
		rabbitMQMessageSender.setName("TestMessage");
		rabbitMQMessageSender.setDescription("TestMessageDescription");
		rabbitTemplate.convertAndSend("MyExchange", "routingKey", rabbitMQMessageSender);
	}

}
