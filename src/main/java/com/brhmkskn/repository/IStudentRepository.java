package com.brhmkskn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brhmkskn.entities.Student;

@Repository
public interface IStudentRepository  extends JpaRepository<Student, Integer>{

}
