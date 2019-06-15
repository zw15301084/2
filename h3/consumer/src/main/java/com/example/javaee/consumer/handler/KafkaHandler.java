package com.example.javaee.consumer.handler;

import com.alibaba.fastjson.JSON;
import com.example.javaee.consumer.entity.MsgBean;
import com.example.javaee.consumer.service.CustomMultiThreadingService;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaHandler {


	CustomMultiThreadingService customMultiThreadingService;
	
	@Autowired
	public KafkaHandler(CustomMultiThreadingService customMultiThreadingService){
		this.customMultiThreadingService = customMultiThreadingService;
	}

	@KafkaListener(topics = "member", groupId = "member-group")
    public void listen(String message) {
		System.out.println(message);
		MsgBean user = JSON.parseObject(message, MsgBean.class);
		customMultiThreadingService.executeAysncMember(user);
	}

	@KafkaListener(topics = "course", groupId = "course-group")
	public void listen2(String message) {
		System.out.println(message);
		
		MsgBean user = JSON.parseObject(message, MsgBean.class);
		customMultiThreadingService.executeAsyncClass(user);
	}
}