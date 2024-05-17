package com.craft.salesordermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication


public class SalesOrderManagementServiceApplication {
	@Bean
	public RestTemplate restTemplateConfiguration() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SalesOrderManagementServiceApplication.class, args);
	}
}
