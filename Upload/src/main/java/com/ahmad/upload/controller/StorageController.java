package com.ahmad.upload.controller;

import com.ahmad.upload.message.Message;
import com.ahmad.upload.message.MessagingConfig;
import com.ahmad.upload.service.S3Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.ahmad.upload.message.MessagingConfig.EXCHANGE;


@RestController
public class StorageController {



    @Autowired
    private S3Service s3Service;

    @Autowired
    private RabbitTemplate template;


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        Message message = new Message();
        message.setMessage("new file uploaded");
        s3Service.saveFile(file);

        template.convertAndSend(EXCHANGE, MessagingConfig.ROUTING_KEY,message);
        return "file uploaded and message sent !!";

    }

}
