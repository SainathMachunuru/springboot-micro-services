package com.msng.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogserviceApplication.class, args);
	}

}
