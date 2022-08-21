package com.truongtv14.RabbitMQ.configuration.sender;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMQMessageSender {
	 private String name;
	 private String description;
	 
	 @Autowired
	 public String toString() {
		return "RabbitMQMessageSender{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
	 }
}
