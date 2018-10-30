package com.skilltrace.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilltrace.model.EmployeeSkill;

@Repository
public interface EmployeeSkillRepo extends JpaRepository<EmployeeSkill, Long>{

	List<EmployeeSkill> findAllByEmployeeId(long employeeId);
	List<EmployeeSkill> findAllByEmployeeName(String employeeName);
	List<EmployeeSkill> findAllBySkillName(String skillName);

}
