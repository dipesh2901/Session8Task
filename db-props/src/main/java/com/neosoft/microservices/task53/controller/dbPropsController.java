package com.neosoft.microservices.task53.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.microservices.task53.bean.DbProps;
import com.neosoft.microservices.task53.configuration.Configuration;



@RestController
public class dbPropsController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/db-prop")
	public DbProps retrieveprops() {
		return new DbProps(configuration.getDriver_class_name(), configuration.getUrl(),configuration.getUsername(),configuration.getPassword());
	}
}
