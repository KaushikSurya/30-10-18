package com.skilltrace.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	
	@NotEmpty(message="Name can not be empty")
	private String employeeName;
	
	@NotEmpty(message="Department can not be empty")
	private String department;
	
	@NotEmpty(message="Designation can not be empty")
	private String designation;
	
	@NotEmpty(message="Email can not be empty")
	private String emailId;
	
	@NotEmpty(message="Mobile Number can not be empty")
	private String mobileNumber;
	
	@NotEmpty(message="Company can not be empty")
	private String company;
	
	public Employee() {
		
	}


	public Employee(long employeeId, @NotEmpty(message = "Name can not be empty") String employeeName,
			@NotEmpty(message = "Department can not be empty") String department,
			@NotEmpty(message = "Designation can not be empty") String designation,
			@NotEmpty(message = "Email can not be empty") String emailId,
			@NotEmpty(message = "Mobile Number can not be empty") String mobileNumber,
			@NotEmpty(message = "Company can not be empty") String company) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
		this.designation = designation;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.company = company;
	}



	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDept() {
		return department;
	}

	public void setDept(String department) {
		this.department = department;
	}

	public String getEmail() {
		return emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getMbno() {
		return mobileNumber;
	}

	public void setMbno(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/*public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}*/
	
	

	
}
