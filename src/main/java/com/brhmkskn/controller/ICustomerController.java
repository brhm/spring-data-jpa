package com.brhmkskn.controller;

import com.brhmkskn.dto.DtoCustomer;

public interface ICustomerController {

	public DtoCustomer getCustomerById(Long id);
}
