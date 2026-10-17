package com.brhmkskn.controller.impl;

import com.brhmkskn.services.impl.StudentServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	private final StudentServiceImpl studentServiceImpl;
	@Autowired
	private IStudentService studentService;

	StudentControllerImpl(StudentServiceImpl studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}
	
	// send DTO 
	@PostMapping(path ="/save")
	@Override
	public Student saveStudent(@RequestBody Student student) {

		return studentService.saveStudent(student);
	}


	@GetMapping(path ="/list")
	@Override
	public List<Student> getAllStudents() {
		List<Student> list=studentService.getAllStudents();
		return list;
	}
	

}
