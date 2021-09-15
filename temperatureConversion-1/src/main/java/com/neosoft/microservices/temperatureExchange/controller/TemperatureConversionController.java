package com.neosoft.microservices.temperatureExchange.controller;

import java.math.BigDecimal;
//import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import com.neosoft.microservices.temperatureExchange.bean.TemperatureConversion;
import com.neosoft.microservices.temperatureExchange.proxy.TemperatureExchangeProxy;

@RestController
public class TemperatureConversionController {
	@Autowired
	TemperatureExchangeProxy proxy;

	// http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	// @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")

	// http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
	@GetMapping("/temperature-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public TemperatureConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		/*
		 * HashMap<String,String> uriVariables = new HashMap<>();
		 * uriVariables.put("from", from); uriVariables.put("to", to);
		 * 
		 * ResponseEntity<CurrencyConversion> reponseEntity = new RestTemplate()
		 * .getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",
		 * CurrencyConversion.class,uriVariables);
		 * 
		 * CurrencyConversion currencyConversion = reponseEntity.getBody();
		 */
		TemperatureConversion temperatureConversion = proxy.retrieveExchangeValue(from, to);
		return new TemperatureConversion(temperatureConversion.getId(), from, to, quantity,
				temperatureConversion.getConversionMultiple(),
				quantity.multiply(temperatureConversion.getConversionMultiple()),
				temperatureConversion.getEnvironment() + " " + " feign...");
		// currencyConversion.getEnvironment()+" "+"rest template");
	}

}
