package com.hbhs.example.B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@EnableEurekaClient
@EnableHystrixDashboard
@EnableHystrix
@ComponentScan(value = "com.hbhs.example.B")
public class BAppBoot {

    public static void main(String[] args) {
        SpringApplication.run(BAppBoot.class);
        System.out.println("service-B started...'");
    }
}
