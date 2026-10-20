package com.brhmkskn.controller;

import java.util.List;

import com.brhmkskn.dto.DtoStudent;
import com.brhmkskn.dto.DtoStudentIU;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU student);
	public List<DtoStudent> getAllStudents();
	public DtoStudent getStudentById(Integer id);
	public DtoStudent getStudentByName(String name);
	public void deleteStudent(Integer id);
	public DtoStudent updateStudent(Integer id,DtoStudentIU student);

}
