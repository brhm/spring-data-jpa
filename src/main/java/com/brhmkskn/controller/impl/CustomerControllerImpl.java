package com.brhmkskn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.ICustomerController;
import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.services.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController{

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(path="/list/{id}")
	public DtoCustomer getCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.getCustomerById(id);
	}
	

}
