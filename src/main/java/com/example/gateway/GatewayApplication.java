package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "application-echo");
		SpringApplication.run(GatewayApplication.class, args);
	}

}
