package com.hbhs.example.A.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BFallbackFactory implements FallbackFactory<BClient> {
    public BClient create(Throwable throwable) {
        String message1 = "";
        if (throwable !=null){
            message1 = throwable.getMessage();
        }
        final String message = message1;
        return new BClient() {
            public String service1() {
                return "B:service-1:fallback:"+message;
            }

            public String service2(Integer second) {
                return "B:service-2:fallback:"+message;
            }

            public String service3(Integer second) {
                return "B:service-3:fallback:"+message;
            }
        };
    }
}
