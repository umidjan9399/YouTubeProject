package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {
    @RabbitListener(queues = {"notification"})
    public void receiveMessage(String fileBody) {
        System.out.println("Message " + fileBody);
    }
}
