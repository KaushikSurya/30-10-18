package com.skilltrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltrace.model.Employee;
import com.skilltrace.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	public EmployeeRepo empRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		empRepo.save(employee);
		return employee;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		boolean isDeleted = false;
		if(empRepo.existsByEmployeeId(employee.getEmployeeId())) {
			empRepo.deleteByEmployeeId(employee.getEmployeeId());
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> opt = empRepo.findByEmployeeId(employeeId);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
}
