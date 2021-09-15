package com.neosoft.microservices.temperatureExchange.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neosoft.microservices.temperatureExchange.bean.TemperatureConversion;

@FeignClient(name = "temperature-exchange")
public interface TemperatureExchangeProxy {

	@GetMapping("/temperature-exchange/{from}/to/{to}")
	public TemperatureConversion retrieveExchangeValue(
			@PathVariable String from, @PathVariable String to);
}
