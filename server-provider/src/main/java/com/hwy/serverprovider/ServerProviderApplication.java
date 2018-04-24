package com.hwy.serverprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProviderApplication.class, args);
	}
}
