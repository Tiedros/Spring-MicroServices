package com.tiedros.microservices.currencyexchangeservice.service;

import org.springframework.stereotype.Service;

import com.tiedros.microservices.currencyexchangeservice.entities.ExchangeValue;


public interface CurrencyExchangeService {
	ExchangeValue findByFromAndTo(String from,String to);
}
