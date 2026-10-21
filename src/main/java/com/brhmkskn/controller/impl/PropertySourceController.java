package com.brhmkskn.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.configuration.GlobalConfigurationProperties;
import com.brhmkskn.configuration.GlobalProperties;
import com.brhmkskn.configuration.Server;
import com.brhmkskn.controller.IAddressController;
import com.brhmkskn.dto.DataSource;
import com.brhmkskn.dto.DtoAddress;
import com.brhmkskn.services.IAddressService;

import lombok.experimental.var;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController{

	@Autowired
	private GlobalProperties globalProperties;

	@Autowired
	private GlobalConfigurationProperties globalConfigurationProperties;
	
	
	@GetMapping(path="/datasource")
	public GlobalProperties getDatasource() {
		DataSource datasource=new DataSource();
		datasource.setUrl(globalProperties.getUrl());
		datasource.setUsername(globalProperties.getUsername());
		datasource.setPassword(globalProperties.getPassword());
		return globalProperties;
	}
	
	@GetMapping(path="/servers")
	public List<Server> getServers() {
	
		System.out.println("Key value: "+ globalConfigurationProperties.getKey());
		
		return globalConfigurationProperties.getServers();
	}

	
	

}
