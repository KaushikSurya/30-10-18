package com.skilltrace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltrace.model.Employee;
import com.skilltrace.model.EmployeeReport;
import com.skilltrace.repo.EmployeeRepo;
import com.skilltrace.repo.ReportRepo;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportRepo reportRepo;
	
	@Autowired 
	private EmployeeRepo empRepo;
	
	private SkillService skillService;
	
	@Override
	public List<EmployeeReport> getAllReports() {
		return reportRepo.findAll();
	}

	@Override
	public EmployeeReport getReportById(long skillId) {
		Optional<EmployeeReport> opt = reportRepo.findById(skillId);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public EmployeeReport addReport(long employeeId, String employeeName) {
		EmployeeReport report = new EmployeeReport();
		report.setEmployeeId(employeeId);
		report.setEmployeeName(employeeName);
		double finalScore = skillService.calculateFinalScore(employeeId);
		report.setFinalScore(finalScore);
		reportRepo.save(report);
		return report;
	}
	
	@Override
	public void addReports(double finalScore) {
		List<Employee> employees = empRepo.findAll();
		EmployeeReport report = new EmployeeReport();
		for(int i=0; i<employees.size(); i++) {
			Employee emp = employees.get(i);
			System.out.println("Employee #"+i+" : "+emp.toString());
			report.setEmployeeId(emp.getEmployeeId());
			System.out.println("Id : "+emp.getEmployeeId());
			report.setEmployeeName(emp.getEmployeeName());
			System.out.println("Name : "+emp.getEmployeeName());
			//double finalScore1 = 0.0;
			report.setFinalScore(finalScore);
			reportRepo.save(report);
		}
	}

	

}
