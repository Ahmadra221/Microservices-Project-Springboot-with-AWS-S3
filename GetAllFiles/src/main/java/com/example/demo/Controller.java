package com.example.demo;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@EnableHystrix
//@EnableHystrixDashboard
public class Controller {

    @Autowired
    RestTemplate rest1;

    @Autowired
    RestTemplate rest2;




    @GetMapping("/getallfiles")
    @HystrixCommand(fallbackMethod = "alter",
    commandProperties ={
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
            })
    public String getallfiles(){
        String x1 = rest1.getForObject("http://get-service/get-service/list",String.class);
        return x1;
    }

    public String alter(){
        return "sorry cant solve request get service is down";
    }
}
