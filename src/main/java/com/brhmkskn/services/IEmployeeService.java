package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> getAllEmployees();

	public DtoEmployee getEmployeeById(Long id);
	
	
}
