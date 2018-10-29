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
import com.skilltrace.service.ReportService;

@RestController
@CrossOrigin
@RequestMapping("/employeeskills")
public class EmployeeSkillsApi {
	
	@Autowired
	private EmployeeSkillService empSkillService;
	
	@Autowired
	private ReportService reportService;
	
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
			for(int i=0;i<empSkills.size();i++) {
				EmployeeSkill empSkill = empSkills.get(i);
				reportService.addReport(empSkill.getEmployeeId(),empSkill.getEmployeeName());
			}
			resp = new ResponseEntity<>(empSkills, HttpStatus.OK);
		}
			
		return resp;
	}
	
	
}
