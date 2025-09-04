package com.bank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CustomerServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceMicroserviceApplication.class, args);
	}

}
