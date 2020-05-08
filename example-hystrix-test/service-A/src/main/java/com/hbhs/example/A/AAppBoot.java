package com.hbhs.example.A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@EnableEurekaClient()
@EnableFeignClients(basePackages="com.hbhs.example.A.client")
@EnableHystrixDashboard
@EnableHystrix
@ComponentScan(value = "com.hbhs.example.A")
public class AAppBoot {

    public static void main(String[] args) {
        SpringApplication.run(AAppBoot.class);
        System.out.println("service-A started...'");
    }

}
