package com.brhmkskn.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brhmkskn.dto.DtoCourse;
import com.brhmkskn.dto.DtoStudent;
import com.brhmkskn.dto.DtoStudentIU;
import com.brhmkskn.entities.Course;
import com.brhmkskn.entities.Student;
import com.brhmkskn.repository.IStudentRepository;
import com.brhmkskn.services.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
		DtoStudent response=new DtoStudent();
		Student student=new Student();
		
		BeanUtils.copyProperties(dtoStudent, student);
		Student dbStudent=studentRepository.save(student);
		
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList=new ArrayList<>();
		List<Student> list=studentRepository.findAll();
		
		for (Student student:list) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}
		
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent=new DtoStudent();
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isEmpty())
			return null;
		
		Student dbStudent=optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if(dbStudent.getCourses()!=null && !dbStudent.getCourses().isEmpty())
			for (Course course: dbStudent.getCourses()) 
			{
				DtoCourse dtoCourse=new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				
				dtoStudent.getCourses().add(dtoCourse);
			}
	
		return dtoStudent;
	}
	@Override
	public DtoStudent getStudentByName(String name) {
		DtoStudent response=new DtoStudent();
		//Student optional=studentRepository.findStudentWithSQL(name);
		Student optional=studentRepository.findStudentWithHQL(name);
		
			BeanUtils.copyProperties(optional, response);
			 // optional içindeki student gönderir.
			
		return response;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional=studentRepository.findById(id);		
		if(optional.isPresent())
			studentRepository.delete(optional.get());		
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent) {
		Optional<Student> optional=studentRepository.findById(id);
		DtoStudent dto=new DtoStudent();
		if(optional.isPresent())
		{
			Student dbStudent=optional.get();
			dbStudent.setBirthOfDate(updateStudent.getBirthOfDate());
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			
		 Student updatedStudent=	studentRepository.save(dbStudent);
		 BeanUtils.copyProperties(updatedStudent, dto);
		 return dto;
		}
		return dto;
	}
	

}
