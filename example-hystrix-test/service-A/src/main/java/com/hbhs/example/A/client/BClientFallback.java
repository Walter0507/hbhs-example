package com.hbhs.example.A.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class BClientFallback implements BClient {
    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1(){
        return "B:service-1:fallback";
    }

    @RequestMapping(value = "/service2/sleep", method = RequestMethod.GET)
    public String service2(@RequestParam(value = "second", defaultValue = "10") Integer second){
        return "B:service-2:fallback";
    }

    @RequestMapping(value = "/service3/sleep/random", method = RequestMethod.GET)
    public String service3(@RequestParam(value = "second", defaultValue = "10") Integer second){
        return "B:service-3:fallback";
    }
}
