package com.hwy.eurekaservercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerCenterApplication.class, args);
	}
}
