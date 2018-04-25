package com.hwy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServerConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerConsumerFeignApplication.class, args);
	}
}
