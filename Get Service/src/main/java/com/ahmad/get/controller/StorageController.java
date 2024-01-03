package com.ahmad.get.controller;

import com.ahmad.get.service.S3Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
//@EnableHystrix
//@EnableHystrixDashboard
@RequestMapping("/get-service")
public class StorageController {

    @Value("${server.port}")
    int port;



    @Autowired
    RestTemplate rest;

    @Autowired
    private S3Service s3Service;;

    @GetMapping("/list")
    public String getAllFiles(){

        return( "\tCurrently avaliable files are" +"\n"+
                s3Service.listAllFiles()
                +"\tRecently deleted files are:"+
                rest.getForObject("http://delete-service/delete/getDeletedFiles",String.class));

    }

    /*
    @GetMapping("/getDeletedFiles")
    public String getdeletedFiles(){
        return rest.getForObject("http://delete-service/delete/getDeletedFiles",String.class);
    }

     */




    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "alter")
    public String hello(){

        return rest.getForObject("http://delete-service/hello",String.class);

    }

    public String alter(){
        return "sorry Delete service is down cant get deleted files";
    }


    @GetMapping("/hello2")
    @HystrixCommand(fallbackMethod = "alter")
    public String hello2(){

        return ("hello get service running on port "+port);

    }





}
