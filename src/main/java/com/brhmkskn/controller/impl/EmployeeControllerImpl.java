package com.brhmkskn.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.IEmployeeController;
import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.services.IEmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController{

	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping(path="/list")
	public List<DtoEmployee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	

}
