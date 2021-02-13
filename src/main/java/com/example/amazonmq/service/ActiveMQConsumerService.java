package com.example.amazonmq.service;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQConsumerService extends RouteBuilder {

    @Value("${spring.activemq.queue.name}")
    private String queueName;

    @Override
    public void configure() throws Exception {
        from("activemq:" + queueName)
                .log(LoggingLevel.INFO, "${body}")
                .end();
    }

}