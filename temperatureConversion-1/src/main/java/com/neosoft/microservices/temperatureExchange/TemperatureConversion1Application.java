package com.neosoft.microservices.temperatureExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TemperatureConversion1Application {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureConversion1Application.class, args);
	}

}
