package com.example.demo2.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;

public class Sender {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        LOGGER.info("sending payload='{send1}'", payload);
        kafkaTemplate.send("helloworld.t", payload);
    }
    public void send2(String payload) {
        LOGGER.info("sending payload='{send2}'", payload);
        kafkaTemplate.send("test", payload);
    }
}
