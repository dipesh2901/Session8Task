package com.neosoft.microservices.temperatureExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.temperatureExchange.bean.TemperatureExchange;
import com.neosoft.microservices.temperatureExchange.repository.TemperatureExchangeRepo;

@RestController
public class TemperatureExchangeController {

	@Autowired
	private TemperatureExchangeRepo temperatureExchangeRepo;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/temperature-exchange/{temp1}/to/{temp2}")
	public TemperatureExchange getConversion(@PathVariable String temp1,@PathVariable String temp2) {
		TemperatureExchange temperatureExchange=temperatureExchangeRepo.findByFromAndTo(temp1, temp2);
		
		if(temperatureExchange==null)
			throw new RuntimeException("Unable to find data for: "+temp1+" to "+temp2);
		
		String port=environment.getProperty("local.server.port");
		temperatureExchange.setEnvironment(port);
		return temperatureExchange;
	}
}
