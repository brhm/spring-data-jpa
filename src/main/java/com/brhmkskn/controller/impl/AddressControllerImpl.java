package com.brhmkskn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.IAddressController;
import com.brhmkskn.dto.DtoAddress;
import com.brhmkskn.services.IAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController{

	@Autowired
	private IAddressService addressService;
	
	@GetMapping(path="/list/{id}")
	public DtoAddress getAddressById(@PathVariable(name = "id") Long id) {
		return addressService.getAddressById(id);
	}

	
	

}
