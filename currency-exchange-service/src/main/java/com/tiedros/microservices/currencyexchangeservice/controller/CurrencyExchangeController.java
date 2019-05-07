package com.tiedros.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiedros.microservices.currencyexchangeservice.entities.ExchangeValue;
import com.tiedros.microservices.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		//ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to,BigDecimal.valueOf(30));
		ExchangeValue exchangeValue =currencyExchangeService.findByFromAndTo(from, to);
		System.out.println("exchangeValue: "+exchangeValue);
		if(exchangeValue != null) {
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		}
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}
}
