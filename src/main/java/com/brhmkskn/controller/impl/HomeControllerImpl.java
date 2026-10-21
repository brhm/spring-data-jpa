package com.brhmkskn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.IHomeController;
import com.brhmkskn.dto.DtoHome;
import com.brhmkskn.services.IHomeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController{

	@Autowired
	private IHomeService homeService;
	
	@GetMapping(path="/list/{id}")
	public DtoHome getHomeById(@PathVariable(name = "id") Long id) {
		return homeService.getHomeById(id);
	}
	

}
