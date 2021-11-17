package com.cov.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cov.beans.Employee;
import com.cov.service.Saver;

public class App05 {

	public static void main(String[] args) {

		ApplicationContext ctxt = new FileSystemXmlApplicationContext("spring.xml");
		Saver saver = (Saver) ctxt.getBean("saver");
		Employee employee = new Employee(101, "akhila", 10);
		saver.save(employee);
		System.out.println("new employee is saved");

	}

}
