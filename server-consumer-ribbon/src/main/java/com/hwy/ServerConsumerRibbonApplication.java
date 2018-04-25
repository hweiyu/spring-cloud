package com.hwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
//@EnableCircuitBreaker或@EnableHystrix
//@SpringCloudApplication
public class ServerConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerConsumerRibbonApplication.class, args);
    }
}
