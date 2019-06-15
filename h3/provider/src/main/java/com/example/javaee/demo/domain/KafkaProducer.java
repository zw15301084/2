package com.example.javaee.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
 
 
    @Value("${message.topic.name1}")
    private String memberTopic;

    @Value("${message.topic.name2}")
    private String courseTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToMemberTopic(String msg){
        kafkaTemplate.send(memberTopic, msg);
    }

    public void sendMessageToCourseTopic(String string){
        kafkaTemplate.send(memberTopic, string);
    }

}