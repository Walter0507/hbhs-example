package com.hbhs.example.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class EurekaServerApplicationBoot {

    public static void main(String[] args) {
        try {
            SpringApplication.run(EurekaServerApplicationBoot.class, args);
        } catch (Exception e) {
            log.error("Start eureka-server error", e);
        }
    }
}
