package com.cov.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Department;
import com.cov.repository.DepartmentRepository;

@TestInstance(Lifecycle.PER_CLASS)
class DepartmentServiceTest {
	@InjectMocks
	DepartmentService departmentService;
	@Mock
	DepartmentRepository departmentRepository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindAll() {
		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1, "Sales"));
		departments.add(new Department(2, "Production"));
		departments.add(new Department(3, "Integrations"));
		departments.add(new Department(4, "Administration"));
		when(departmentRepository.findAll()).thenReturn(departments);
		List<Department> departmentList = departmentService.findAll();
		assertNotNull(departmentList);
		//assertEquals(3, personList.size());
		//fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		Department departmentExisting = new Department(2, "Production");
		when(departmentRepository.findById(2)).thenReturn(Optional.of(departmentExisting));
		Department department = departmentRepository.findById(2).get();
		assertNotNull(department);
		assertSame(department.getName(), "Production");
		//assertEquals(person.getId(), 3);
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		Department department = new Department(5, "Management");
		when(departmentRepository.save(department)).thenReturn(department);
		
		Department department1 = departmentRepository.save(department);
		assertNotNull(department1);
		assertSame(department1.getName(), "Management");
		assertEquals(department1.getId(), 5);

		//fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		Department department = new Department(3, "Marketing");
		when(departmentRepository.save(department)).thenReturn(department);

		Department department1 = departmentRepository.save(department);
		assertNotNull(department1);
		assertSame(department1.getName(), "Marketing");
		//assertEquals(person1.getId(), 3);
		//fail("Not yet implemented");
	}

	
	/* @Test void testDelete() {
		 Person personExisting = new Person(2, "Akhila", "Reddy");
			when(personRepository.findById(2)).thenReturn(Optional.of(personExisting));
			
			Person person = personRepository.deleteById(2);
			
	  fail("Not yet implemented");
	  }*/
	 

}
