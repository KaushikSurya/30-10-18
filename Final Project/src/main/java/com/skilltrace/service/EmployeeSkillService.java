package com.skilltrace.service;

import java.util.List;

import com.skilltrace.model.EmployeeSkill;

public interface EmployeeSkillService {
	public List<EmployeeSkill> getAllEmployeeSkills(long employeeId);
	public List<EmployeeSkill> getEmployeesByEmployeeName(String employeeName);
	public List<EmployeeSkill> getEmployeesBySkillName(String skillName);
	public List<EmployeeSkill> getAllEmployeesSkill();
}
