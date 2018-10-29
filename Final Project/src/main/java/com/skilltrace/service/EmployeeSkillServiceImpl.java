package com.skilltrace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltrace.model.EmployeeSkill;
import com.skilltrace.repo.EmployeeSkillRepo;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {
	
	@Autowired
	private EmployeeSkillRepo empSkillsRepo;

	@Override
	public List<EmployeeSkill> getAllEmployeeSkills(long employeeId) {
		return empSkillsRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public List<EmployeeSkill> getEmployeesBySkillName(String skillName) {
		return empSkillsRepo.findAllBySkillName(skillName);
	}

	@Override
	public List<EmployeeSkill> getAllEmployeesSkill() {
		return empSkillsRepo.findAll();
	}

}
