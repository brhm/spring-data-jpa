package com.brhmkskn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brhmkskn.entities.Student;

@Repository
public interface IStudentRepository  extends JpaRepository<Student, Integer>{

	// write custom queries.
	// HQL : sınıfın ismi ve değişken isimleri kullanarak sorgular yazılır nativeQuery=false olur
	// SQL : db deki tablo ismi ve kolon isimlerine sorgular ve nativeQuery = true olur.
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudentsWithHQL();	

	@Query(value = "from Student where firstName=:name  LIMIT 1", nativeQuery = false)
	Student findStudentWithHQL(@Param("name") String name);	

	@Query(value = "select * from student.student", nativeQuery = true)
	List<Student> findAllStudentsWithSQL();	
	

	@Query(value = "select * from student.student where first_name=:name  LIMIT 1", nativeQuery = true)
	Student findStudentWithSQL(@Param("name") String name);	
}
