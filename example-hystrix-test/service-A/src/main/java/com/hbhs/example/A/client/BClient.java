package com.hbhs.example.A.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "example-hystrix-service-B"
//        , fallback = BClientFallback.class
        , fallbackFactory = BFallbackFactory.class
)
public interface BClient {
    @RequestMapping(value = "/service1", method = RequestMethod.GET)
    public String service1();

    @RequestMapping(value = "/service2/sleep", method = RequestMethod.GET)
    public String service2(@RequestParam(value = "second", defaultValue = "10") Integer second);

    @RequestMapping(value = "/service3/sleep/random", method = RequestMethod.GET)
    public String service3(@RequestParam(value = "second", defaultValue = "10") Integer second);
}
