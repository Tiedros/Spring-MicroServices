package com.tiedros.microservices.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiedros.microservices.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.tiedros.microservices.currencyexchangeservice.entities.ExchangeValue;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	
	@Override
	public ExchangeValue findByFromAndTo(String from, String to) {
		// TODO Auto-generated method stub
		return currencyExchangeRepository.findByFromAndTo(from, to);
	}

}
