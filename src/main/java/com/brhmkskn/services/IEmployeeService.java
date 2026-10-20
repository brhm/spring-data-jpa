package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.dto.DtoCustomerUI;
import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.dto.DtoHome;

public interface IEmployeeService {
	
	public List<DtoEmployee> getAllEmployees();
	
}
