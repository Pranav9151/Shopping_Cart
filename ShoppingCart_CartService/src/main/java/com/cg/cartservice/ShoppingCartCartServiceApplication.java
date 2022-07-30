package com.cg.cartservice;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ShoppingCartCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartCartServiceApplication.class, args);
	}

	
}
