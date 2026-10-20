package com.brhmkskn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.dto.DtoCustomer;
import com.brhmkskn.dto.DtoDepartment;
import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.dto.DtoHome;
import com.brhmkskn.dto.DtoRoom;
import com.brhmkskn.entities.Customer;
import com.brhmkskn.entities.Department;
import com.brhmkskn.entities.Employee;
import com.brhmkskn.entities.Home;
import com.brhmkskn.entities.Room;
import com.brhmkskn.repository.IEmployeeRepository;
import com.brhmkskn.repository.IHomeRepository;
import com.brhmkskn.services.IEmployeeService;
import com.brhmkskn.services.IHomeService;


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
}