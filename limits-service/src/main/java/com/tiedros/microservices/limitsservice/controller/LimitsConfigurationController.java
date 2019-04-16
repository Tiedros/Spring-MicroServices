package com.tiedros.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiedros.microservices.limitsservice.beans.limitConfiguration;
import com.tiedros.microservices.limitsservice.config.Config;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Config config;
	
	@RequestMapping("/limits")
	public limitConfiguration retrieveLimitsFromConfiguration() {
		return new limitConfiguration(config.getMinimum(),config.getMaximum());
	}

}
