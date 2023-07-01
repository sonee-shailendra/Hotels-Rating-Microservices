package com.ssonee.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {



	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(UserServiceApplication.class, args);
	}


}
