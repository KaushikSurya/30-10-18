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

import com.skilltrace.model.EmployeeReport;
import com.skilltrace.service.ReportService;
import com.skilltrace.service.SkillService;

@RestController
@CrossOrigin
@RequestMapping("/reports")
public class EmployeeReportApi {
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private SkillService skillService;


	@GetMapping
	public ResponseEntity<List<EmployeeReport>> getAllReports() {
		//double finalScore = skillService.calculateFinalScore(employeeId);
		//reportService.addReports();
		return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeReport> getReportById(@PathVariable("employeeId") long employeeId) {
		ResponseEntity<EmployeeReport> resp;
		double finalScore = skillService.calculateFinalScore(employeeId);
		reportService.addReports(finalScore);
		EmployeeReport empReport = reportService.getReportById(employeeId);
		if (empReport == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(empReport, HttpStatus.OK);
		return resp;
	}
	
	
}
