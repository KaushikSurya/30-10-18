package com.skilltrace.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilltrace.model.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

	boolean existsByEmployeeId(long employeeId);
	void deleteByEmployeeId(long employeeId);
	Optional<Employee> findByEmployeeId(long employeeId);

}
