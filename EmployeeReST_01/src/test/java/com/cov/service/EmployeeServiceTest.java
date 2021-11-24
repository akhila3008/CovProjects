
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

import com.cov.beans.Employee;
import com.cov.beans.Department;
import com.cov.repository.EmployeeRepository;

@TestInstance(Lifecycle.PER_CLASS)
class EmployeeServiceTest {
	@InjectMocks
	EmployeeService employeeService;
	@Mock
	EmployeeRepository employeeRepository;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindAll() {
		Department department1 = new Department(1,"sales");
		Department department2 = new Department(2,"Production");
		Department department3 = new Department(3,"Integration");
		Department department4 = new Department(4,"Administration");
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Akhila", department1));
		employees.add(new Employee(2, "Hasini", department2));
		employees.add(new Employee(3, "Snehitha",department3 ));
		employees.add(new Employee(4, "Manvitha", department4));
		when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> employeeList = employeeService.findAll();
		assertNotNull(employeeList);
		//assertEquals(3, personList.size());
		//fail("Not yet implemented");
	}

	private Department department(int i, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void testFindById() {
		Department department2 = new Department(2,"Production");
		Employee employeeExisting = new Employee(2, "Hasini", department2);
		when(employeeRepository.findById(2)).thenReturn(Optional.of(employeeExisting));
		Employee employee = employeeRepository.findById(2).get();
		assertNotNull(employee);
		assertSame(employee.getName(), "Hasini");
		//assertEquals(person.getId(), 3);
		//fail("Not yet implemented");
	}

	@Test
	void testSave() {
		Department department = new Department(1,"sales");
		Employee employee = new Employee(5, "Akhil", department);
		when(employeeRepository.save(employee)).thenReturn(employee);
		
		Employee employee1 = employeeRepository.save(employee);
		assertNotNull(employee1);
		assertSame(employee1.getName(), "Akhil");
		assertEquals(employee1.getId(), 5);

		//fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		Department department = new Department(1,"sales");
		Employee employee = new Employee(3, "AAkhila", department);
		when(employeeRepository.save(employee)).thenReturn(employee);

		Employee employee1 = employeeRepository.save(employee);
		assertNotNull(employee1);
		assertSame(employee1.getName(), "AAkhila");
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
