package com.cg.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartCartServiceApplication.class, args);
	}

}
