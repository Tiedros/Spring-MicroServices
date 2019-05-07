package com.tiedros.microservices.currencyexchangeservice.controller;



import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tiedros.microservices.currencyexchangeservice.entities.CurrencyConversionBean;
import com.tiedros.microservices.currencyexchangeservice.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	private  Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@RequestMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		System.out.println(">>>>>>>> CurrencyConversionBean(): ");
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversionBean.class,
						uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		logger.info("{}",response);
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(response.getId(), from,to,response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		
		return currencyConversionBean;
	}
	
	@RequestMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(response.getId(), from,to,response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		
		return currencyConversionBean;
	}

}
