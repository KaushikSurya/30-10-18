package com.skilltrace.service;

import java.util.List;

import com.skilltrace.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	public Employee getEmployeeById(long employeeId);
	public List<Employee> getAllEmployees();
	
}