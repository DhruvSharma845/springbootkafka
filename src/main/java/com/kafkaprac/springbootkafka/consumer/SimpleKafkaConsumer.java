package com.kafkaprac.springbootkafka.consumer;

import com.kafkaprac.springbootkafka.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Profile("kafka-consumer")
@Service
public class SimpleKafkaConsumer {


    @KafkaListener(topics = "simple", groupId = "group_id_1")
    public void consumeMessageFromTopic(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "complex", containerFactory = "kafkaListenerContainerFactory", clientIdPrefix = "json")
    public void listenAsObject(ConsumerRecord<String, Message> cr, @Payload Message message) {
        System.out.println("[JSON] Received: Key: " + cr.key() + " payload: " + message);
    }

    @KafkaListener(topics = "complex", containerFactory = "kafkaListenerStringContainerFactory", clientIdPrefix = "string")
    public void listenAsString(ConsumerRecord<String, String> cr, @Payload String message) {
        System.out.println("[String] Received: Key: " + cr.key() + " payload: " + message);
    }
}
