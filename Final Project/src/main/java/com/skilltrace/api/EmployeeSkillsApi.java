package com.skilltrace.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltrace.model.EmployeeSkill;
import com.skilltrace.service.EmployeeSkillService;

@RestController
@CrossOrigin
@RequestMapping("/employeeskills")
public class EmployeeSkillsApi {
	
	@Autowired
	private EmployeeSkillService empSkillService;
	
	//private ReportService reportService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeSkill>> getAllSkills() {
		return new ResponseEntity<>(empSkillService.getAllEmployeesSkill(), HttpStatus.OK);
	}


	@GetMapping("/{employeeId}")
	public ResponseEntity<List<EmployeeSkill>> getEmployeeById(@PathVariable("employeeId") long employeeId) {
		ResponseEntity<List<EmployeeSkill>> resp;
		List<EmployeeSkill> empSkills = empSkillService.getAllEmployeeSkills(employeeId);		
		if (empSkills == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			resp = new ResponseEntity<>(empSkills, HttpStatus.OK);
		}
			
		return resp;
	}
	
	
}
