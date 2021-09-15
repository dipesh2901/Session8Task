package com.neosoft.microservices.temperatureExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.microservices.temperatureExchange.bean.TemperatureExchange;

@Repository
public interface TemperatureExchangeRepo extends JpaRepository<TemperatureExchange,Long> {

	TemperatureExchange findByFromAndTo(String from, String to);
	
}
