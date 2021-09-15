package com.neosoft.microservices.temperatureExchange.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TemperatureExchange {

	@Id
	private long id;

	@Column(name = "temperature_from")
	private String from;

	@Column(name = "temperature_to")
	private String to;

	private BigDecimal conversionMultiple;

	private String environment;

}
