package com.tiedros.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiedros.microservices.currencyexchangeservice.entities.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
 ExchangeValue findByFromAndTo(String from,String to);
}
