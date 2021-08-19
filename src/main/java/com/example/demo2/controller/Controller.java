package com.example.demo2.controller;

import com.example.demo2.consumer.Receiver;
import com.example.demo2.consumer.SpringContextUtil;
import com.example.demo2.producer.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class Controller {
    /*@Autowired
    private Receiver receiver;*/
    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(String msg) throws Exception {
        Receiver receiver = (Receiver) SpringContextUtil.getBean("testController");
        sender.send("Hello Spring Kafka!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return "send ok";
    }
/*
    @RequestMapping("/send2")
    public String send2(String msg) throws Exception {
        sender.send2("Hello Spring Kafka2!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return "send ok";
    }*/
}
