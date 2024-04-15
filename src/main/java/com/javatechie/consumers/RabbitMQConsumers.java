package com.javatechie.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javatechie.config.RabbitMQConfig;

@Component
public class RabbitMQConsumers {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
    	try {
    	    Thread.sleep(5000); // Sleep for 5 seconds
    	    System.out.println("Received message: " + message);
    	} catch (InterruptedException e) {
    	    Thread.currentThread().interrupt();
    	}
    	
        
    }
}
