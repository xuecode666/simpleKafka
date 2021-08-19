package com.example.demo2.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver2 {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver2.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

//    @KafkaListener(topics = "helloworld.s")
    public void receive(String payload) {
        LOGGER.info("received11111 payload='{}'", payload);
        latch.countDown();
    }
  /*  @KafkaListener(topicPattern = "helloworld.*")
    public void listen2(ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("helloworld.* = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }*/



}
