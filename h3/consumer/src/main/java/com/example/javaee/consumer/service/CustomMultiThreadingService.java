package com.example.javaee.consumer.service;

import com.example.javaee.consumer.entity.MsgBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CustomMultiThreadingService {
    
    @Autowired
    HandlerService handlerService;


    @Async
    public void executeAysncMember(MsgBean user){
        //接受msgBean 处理申请成为会员的 请求
        int customer_id = user.getCustomerid();
        handlerService.become_vip_member(customer_id);
    }
    
    @Async
    public void executeAsyncClass(MsgBean user){
        //接受msgBean 处理申请成为课程学生的 请求
        int customer_id = user.getCustomerid();
        int class_id = Integer.valueOf(user.getData());
        handlerService.become_class_member(class_id, customer_id);
    }
}