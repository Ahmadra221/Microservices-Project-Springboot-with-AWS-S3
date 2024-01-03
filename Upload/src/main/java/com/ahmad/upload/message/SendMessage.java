package com.ahmad.upload.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.ahmad.upload.message.MessagingConfig.EXCHANGE;

@RestController
public class SendMessage {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/send")
    public String sendRequest(@RequestBody Message message) {
        //message.setMessageId(UUID.randomUUID().toString());
        //restaurantservice
        //payment service
        template.convertAndSend(EXCHANGE, MessagingConfig.ROUTING_KEY,message);
        return "Message Sent !!";
    }
}
