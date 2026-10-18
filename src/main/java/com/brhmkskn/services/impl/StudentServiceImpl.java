package com.brhmkskn.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.entities.Student;
import com.brhmkskn.repository.IStudentRepository;
import com.brhmkskn.services.IStudentService;

import lombok.experimental.var;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list=studentRepository.findAll();
		return list;
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isPresent())
			return optional.get(); // optional içindeki student gönderir.
		
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dbStudent=getStudentById(id);
		
		if(dbStudent!=null)
			studentRepository.delete(dbStudent);
		
	}

	@Override
	public Student updateStudent(Integer id, Student updateStudent) {
		Student dbStudent=getStudentById(id);
		
		if(dbStudent!=null)
		{
			dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			
		 return	studentRepository.save(dbStudent);
		}
		return null;
	}
	

}
