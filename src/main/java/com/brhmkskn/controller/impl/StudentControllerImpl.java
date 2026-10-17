package com.brhmkskn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.IStudentController;
import com.brhmkskn.entities.Student;
import com.brhmkskn.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

	@Autowired
	private IStudentService studentService;
	
	// send DTO 
	@PostMapping(path ="save")
	@Override
	public Student saveStudent(@RequestBody Student student) {

		return studentService.saveStudent(student);
	}
	

}
