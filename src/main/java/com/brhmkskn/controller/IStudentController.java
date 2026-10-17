package com.brhmkskn.controller;

import java.util.List;

import com.brhmkskn.entities.Student;

public interface IStudentController {

	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
}
