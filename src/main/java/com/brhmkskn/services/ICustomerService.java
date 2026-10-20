package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.dto.DtoCustomerUI;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerUI customer);
	
	public List<DtoCustomer> getAllCustomers();
	
	public DtoCustomer getCustomerById(Long id);
	
	public void deleteCustomer(Long id);
	
	public DtoCustomer updateCustomer(Long id,DtoCustomerUI updateCustomer);
}
