package com.brhmkskn.controller;

import java.util.List;

import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.model.RootEntity;

public interface IEmployeeController {

	public RootEntity<List<DtoEmployee>> getAllEmployees();
	public RootEntity<DtoEmployee> getEmployeeById(Long id);
}
