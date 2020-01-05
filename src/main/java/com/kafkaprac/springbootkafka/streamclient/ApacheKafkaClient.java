package com.kafkaprac.springbootkafka.streamclient;

import com.kafkaprac.springbootkafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Profile("kafka-publisher")
@Service
public class ApacheKafkaClient {

    @Value("${kafka.topic1.name}")
    private String topicName;

    @Value("${kafka.topic2.name}")
    private String secondTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate1;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate2;

    public void sendMessageToTopic(String message) {
        this.kafkaTemplate1.send(topicName, message);
    }

    public void sendMessageModel(int i, Message message) {
        this.kafkaTemplate2.send(secondTopicName, String.valueOf(i), message);
    }
}
