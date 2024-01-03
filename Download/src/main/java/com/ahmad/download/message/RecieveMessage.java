package com.ahmad.download.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RecieveMessage {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void receiveMessage(Message message){
        System.out.println("message:"+message);
    }
}
