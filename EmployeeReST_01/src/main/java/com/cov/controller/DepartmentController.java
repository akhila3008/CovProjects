
package com.cov.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cov.beans.Department;
import com.cov.exception.InvalidDepartmentIdException;
import com.cov.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "API to perform operations on Department", 
     description = "This API provides capability to perform CRUD operations on Department")

@RestController
@RequestMapping("/department")
public class DepartmentController {
	static Logger logger = Logger.getLogger(DepartmentController.class);
	@Autowired
	DepartmentService departmentService;
    
	@ApiOperation(value="Search  for a single department based on the provided ID", response=Department.class, produces="application/xml")
	@GetMapping("/{id}")
	public Department find(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("finding a employee with id " + id);
		Department department = departmentService.findById(id);
		logger.info("employee found with id " + id + " is" + department.getName());
		return department;
	}
	@ApiOperation(value="Search for all the Departments",produces="application/xml" )
	
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrived all the Departments"),
			@ApiResponse(code=401, message="You are not authorized to use the repository"),
			@ApiResponse(code=403, message="You are forbidden to access the resources"),
			@ApiResponse(code=404, message="The resource you are trying to reach is not found")
	})
	@GetMapping()
	public List<Department> findAll() {
		logger.info("finding all departments");
		return departmentService.findAll();
	}
	@ApiOperation(value="Insert a new department",produces="application/xml" )
	@PostMapping()
	public Department insert(@RequestBody Department department) {
		logger.info("inserting a department with " + department.getName());
		return departmentService.save(department);
	}
	@ApiOperation(value="Edit details of the department",produces="application/xml" )
	@PutMapping()
	public Department edit(@RequestBody Department department) throws InvalidDepartmentIdException {
		logger.info("editing a department with " + department.getName());
		return departmentService.update(department);
	}

	@ApiOperation(value="Delete a department",produces="application/xml" )
	@DeleteMapping("/{id}")
	public Department delete(@PathVariable int id) throws InvalidDepartmentIdException {
		logger.info("deleting a department with id " + id);
		return departmentService.delete(id);
	}
}