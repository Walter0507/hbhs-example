package com.hbhs.example.A.controller;

import com.hbhs.example.A.client.BClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    @Autowired
    private BClient bClient;
    @RequestMapping(value = "/testing", method = RequestMethod.GET)
    public String test1(){
        return "A:test1 -> "+bClient.service1();
    }


    @RequestMapping(value = "/testing2", method = RequestMethod.GET)
    public String test2(@RequestParam(value = "second", defaultValue = "10") Integer second){
        return "A:test2 -> "+bClient.service2(second);
    }



    @RequestMapping(value = "/testing3", method = RequestMethod.GET)
    public String test3(@RequestParam(value = "second", defaultValue = "10") Integer second){
        return "A:test3 -> "+bClient.service3(second);
    }
}
