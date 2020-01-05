package com.kafkaprac.springbootkafka.consumer;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Profile("kafka-consumer")
@Service
public class SimpleKafkaConsumer {

    @KafkaListener(topics = "simple", groupId = "group_id_1")
    public void consumeMessageFromTopic(String message) {
        System.out.println("Consumed message: " + message);
    }
}
