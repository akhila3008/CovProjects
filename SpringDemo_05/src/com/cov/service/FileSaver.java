package com.cov.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cov.beans.Employee;

@Component("saver")
public class FileSaver implements Saver {
	@Value("EmpData.dat")
	String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public void save(Object object) {
		Employee employee = (Employee) object;
		System.out.println("saving the employee in file");
		System.out.println("the file name is" + filename);
		System.out.println("the saved employee is " + employee);

	}

}
