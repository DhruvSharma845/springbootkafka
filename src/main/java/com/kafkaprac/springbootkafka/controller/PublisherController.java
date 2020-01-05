package com.kafkaprac.springbootkafka.controller;

import com.kafkaprac.springbootkafka.model.Message;
import com.kafkaprac.springbootkafka.streamclient.ApacheKafkaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Profile("kafka-publisher")
@RestController
@RequestMapping("/kafka")
public class PublisherController {

    @Autowired
    private ApacheKafkaClient kafkaClient;

    @PostMapping("/publish")
    public void sendMessage(@RequestBody String message) {
        this.kafkaClient.sendMessageToTopic(message);
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }


    @PostMapping("/publish/multiple-consumers")
    public void sendMessageToConsumerGroup(@RequestBody String message) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            this.kafkaClient.sendMessageModel(i%2, new Message(message, i));
        }
    }

}
