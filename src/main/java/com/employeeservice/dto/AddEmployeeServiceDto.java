package com.employeeservice.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class AddEmployeeServiceDto {
	
	@NotEmpty(message="EmployeeStatus Must not be Empty")
	private String employeeStatus;
	
	@NotEmpty(message = "List of employeeDetails not be Empty")
	@Valid
	private List<EmployeeDetailsDto> employeeDetailsDto;

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public List<EmployeeDetailsDto> getEmployeeDetailsDto() {
		return employeeDetailsDto;
	}

	public void setEmployeeDetailsDto(List<EmployeeDetailsDto> employeeDetailsDto) {
		this.employeeDetailsDto = employeeDetailsDto;
	}
	
	
	

}
