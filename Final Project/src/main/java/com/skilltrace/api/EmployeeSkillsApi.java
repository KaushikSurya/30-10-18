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
	
	@GetMapping("/{field}/{srchValue}")
	public ResponseEntity<List<EmployeeSkill>> getAllPlans (
		@PathVariable("field") String fieldBy,
		@PathVariable("srchValue") String searchValue)
	{
		ResponseEntity<List<EmployeeSkill>> resp;
			switch(fieldBy){
			case "employeeName":
				List<EmployeeSkill> eben= empSkillService.getEmployeesByEmployeeName(searchValue);
				if(eben!=null){
					resp=new ResponseEntity<>(eben,HttpStatus.OK);}
				else {
					resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				break;
				
			case "skillName":				
				List<EmployeeSkill> ebsn= empSkillService.getEmployeesBySkillName(searchValue);
				if(ebsn!=null){
					resp=new ResponseEntity<>(ebsn,HttpStatus.OK);}
				else {
					resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);}
				break;
				
			default:
				resp= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				break;	
		}
		
		return resp;
	}
	
	
}
