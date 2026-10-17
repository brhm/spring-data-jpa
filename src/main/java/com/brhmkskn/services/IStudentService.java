package com.brhmkskn.services;

import java.util.List;

import com.brhmkskn.entities.Student;

public interface IStudentService {

	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
}
