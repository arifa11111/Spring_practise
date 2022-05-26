package com.Thymeleaf.thymeleaf.service;

import java.util.List;

import com.Thymeleaf.thymeleaf.Entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}