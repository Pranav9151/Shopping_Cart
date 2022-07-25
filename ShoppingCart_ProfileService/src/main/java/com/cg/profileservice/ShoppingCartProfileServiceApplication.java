package com.cg.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProfileServiceApplication.class, args);
	}

}
