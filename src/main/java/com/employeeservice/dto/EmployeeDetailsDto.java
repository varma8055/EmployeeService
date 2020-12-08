package com.employeeservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeDetailsDto {
	
	@NotEmpty(message = "Employeename must not be Empty")
	@Size(max=50)
	@Column(name="employee_name")
	private String employeeName;
	
	@NotEmpty(message="Gender not be Empty")
	@Size(max=10)
	@Column(name="employee_gender")
	private String employeeGender;
	
	@NotEmpty(message = "Employee email must not be Empty")
	@Email(message="Please enter a valid Email address")
	@Size(max=100)
	@Column(name="employee_email")
	private String employeeEmail;
	
	@NotEmpty(message="Please provide Designation")
	@Size(max=80)
	@Column(name="employee_designation")
	private String employeeDesignation;
	
	
	private int employeeExperience;
	
	@NotEmpty(message="Please provide valid phone number")
	@Size(max=100)
	@Column(name="employee_phone_number")
	private String employeePhoneNumber;
	
	
	
	@NotEmpty(message="Enter the Location")
	@Column(name="employee_location")
	private String employeeLocation;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public int getEmployeeExperience() {
		return employeeExperience;
	}
	public void setEmployeeExperience(int employeeExperience) {
		this.employeeExperience = employeeExperience;
	}
	
	
	public String getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public void setEmployeePhoneNumber(String employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	
	

}
