package com.brhmkskn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.dto.DtoDepartment;
import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.entities.Department;
import com.brhmkskn.entities.Employee;
import com.brhmkskn.repository.IEmployeeRepository;
import com.brhmkskn.services.IEmployeeService;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<DtoEmployee> getAllEmployees() {
		List<DtoEmployee> dtoList=new ArrayList<>();
		List<Employee> list=employeeRepository.findAll();
		
		for (Employee employee:list) {
			DtoEmployee dtoEmployee = new DtoEmployee();
			BeanUtils.copyProperties(employee, dtoEmployee);
				if(employee.getDepartment()!=null)
				{	
					DtoDepartment dtoDepartment=new DtoDepartment();
					Department department=new Department();
					department=employee.getDepartment();
	
					BeanUtils.copyProperties(department, dtoDepartment);
					dtoEmployee.setDepartment(dtoDepartment);
				}
			dtoList.add(dtoEmployee);
		}
		
		return dtoList;
	}

	@Override
	public DtoEmployee getEmployeeById(Long id) {
		DtoEmployee dtoEmployee=new DtoEmployee();
		DtoDepartment dtoDepartment=new DtoDepartment();
		
		Optional<Employee> optional=employeeRepository.findById(id);
		
		if(optional.isEmpty())
			return null;
		
		Employee employee=optional.get();
		Department department=employee.getDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
			
		
		return dtoEmployee;
	}
}