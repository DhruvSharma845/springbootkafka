package com.kafkaprac.springbootkafka.controller;

import com.kafkaprac.springbootkafka.streamclient.ApacheKafkaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

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

}
