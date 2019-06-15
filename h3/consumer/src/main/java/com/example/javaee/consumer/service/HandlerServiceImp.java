package com.example.javaee.consumer.service;

import com.example.javaee.consumer.repositroy.HandlerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class HandlerServiceImp implements HandlerService {

    HandlerRepository handlerRepository;

    @Autowired
    public HandlerServiceImp(HandlerRepository handlerRepository){
        this.handlerRepository = handlerRepository;
    }

    @Override
    public void become_class_member(int class_id, int customer_id) {
        handlerRepository.become_class_member(class_id, customer_id);
    }

    @Override
    public void become_vip_member(int customer_id) {
        handlerRepository.become_vip_member(customer_id);
    }

    



}