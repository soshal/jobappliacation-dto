package com.example.service_rep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRepApplication.class, args);
	}

}
