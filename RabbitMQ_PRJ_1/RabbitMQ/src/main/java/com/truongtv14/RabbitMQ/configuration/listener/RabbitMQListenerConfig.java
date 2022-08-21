package com.truongtv14.RabbitMQ.configuration.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQListenerConfig {
	private static final String MY_QUEUE = "MyQueue";
	private static final String MY_EXCHANGE = "MyExchange";

	@Bean
	Queue myQueue() {
		return new Queue(MY_QUEUE, true);
	}

	@Bean
	Exchange myTestExchange() {
		return new TopicExchange(MY_EXCHANGE);
	}
	
    @Bean
    Binding queueBinding() {
        return new Binding(MY_QUEUE, Binding.DestinationType.QUEUE, MY_EXCHANGE, "routingKey", null);
    }

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}

	@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setQueues(myQueue());
		container.setMessageListener(new RabbitMQMessageListener());
		return container;
	}

}
