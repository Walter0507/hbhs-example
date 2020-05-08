package com.hbhs.example.B.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BController {

    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1(){
        return "B:service-1";
    }
    @HystrixCommand(
            fallbackMethod="limitFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1")
            }
    )
    @RequestMapping(value = "/service2/sleep", method = RequestMethod.GET)
    public String service2(@RequestParam(value = "second", defaultValue = "10") Integer second){
        try {
            long sleep = second*1000;
            if (sleep<0){
                sleep = new Random().nextInt(500);
            }
            Thread.sleep(sleep);
        }catch (Exception e){}
        return "B:service-sleep:"+second;
    }

    public String limitFallback(Integer second){
        return "B:service-sleep:limit";
    }

    @RequestMapping(value = "/service3/sleep/random", method = RequestMethod.GET)
    public String service3(@RequestParam(value = "second", defaultValue = "10") Integer second){
        int sleepTime = 0;
        try {
            sleepTime = new Random().nextInt(second*1000);
            Thread.sleep(sleepTime);
        }catch (Exception e){}
        return "B:service-sleep-random:"+sleepTime;
    }
}
