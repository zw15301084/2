package com.example.javaee.consumer.service;

import org.springframework.stereotype.Service;

@Service
public interface HandlerService{

    void become_class_member(int class_id,int customer_id);

    void become_vip_member(int customer_id);

}

