package com.brhmkskn.spring_data_jpa;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brhmkskn.dto.DtoEmployee;
import com.brhmkskn.services.IEmployeeService;
import com.brhmkskn.starter.SpringDataJpaApplication;

@SpringBootTest(classes = {SpringDataJpaApplication.class}) // java starter clasını veriyoruz.bazen testleri starterı bulamıyor.
class SpringDataJpaApplicationTests {

	@Autowired
	private IEmployeeService employeeService;
	
	// CRTL + 1  => metodu tıkladığımız zaman değişkenleri otomatik ekler.
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before test work...");
	}
	
	@Test
	public void testFindEmployeeById() {
	  DtoEmployee employee = employeeService.getEmployeeById(1L);
	  if(employee!=null)
	  {
		  System.out.println("test 1");
		  System.out.println("isim : "+employee.getName());
	  }
	}
	@Test
	public void testGetEmployeeByIdAssertEqualsId() {
	  DtoEmployee employee = employeeService.getEmployeeById(1L);

	  System.out.println("test 2");
	  assertEquals(1L,employee.getId());
	}
	@Test
	public void testGetEmployeeByIdAssertNotNullResult() {
	  DtoEmployee employee = employeeService.getEmployeeById(1L);

	  System.out.println("test 3");
	  assertNotNull(employee);
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("after test work...");
	}
	

}
