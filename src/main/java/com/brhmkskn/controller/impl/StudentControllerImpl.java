package com.brhmkskn.controller.impl;

import com.brhmkskn.services.impl.StudentServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brhmkskn.controller.IStudentController;
import com.brhmkskn.dto.DtoStudent;
import com.brhmkskn.dto.DtoStudentIU;
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
	public DtoStudent saveStudent(@RequestBody DtoStudentIU student) {
		return studentService.saveStudent(student);
	}


	@GetMapping(path ="/list")
	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> list=studentService.getAllStudents();
		return list;
	}
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id") Integer id) {
		// TODO Auto-generated method stub
		return studentService.getStudentById(id);
	}
	
	@GetMapping(path = "/by-name/{name}")
	@Override
	public DtoStudent getStudentByName(@PathVariable(name = "name") String name) {
		// TODO Auto-generated method stub
		return studentService.getStudentByName(name);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Integer id,@RequestBody DtoStudentIU student) {
		// TODO Auto-generated method stub
		return studentService.updateStudent(id, student);
	}
	

}
