package com.cov.service;

import com.cov.beans.Employee;

public class DbSaver implements Saver{
	String driver;
	String url;
	String username;
	String password;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public void save(Object object) {
		Employee employee = (Employee) object;
		System.out.println("saving employee object to database");
		System.out.println("Driver :" + driver);
		System.out.println("URL :" + url);
		System.out.println("Username :" + username);
		System.out.println("Password :" + password);
		System.out.println("the saved employee is :" + employee);
		
	}

}
