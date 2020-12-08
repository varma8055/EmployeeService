package com.employeeservice.service;

import java.util.List;

import javax.validation.Valid;

import com.employeeservice.dto.AddEmployeeServiceDto;
import com.employeeservice.dto.EmployeeDetailsDto;
import com.employeeservice.dto.UpdateEmployeeServiceDto;
import com.employeeservice.entity.EmployeeDetails;

public interface EmployeeService {

	void addEmployee(@Valid AddEmployeeServiceDto employeeDetailsDto);

	UpdateEmployeeServiceDto updateEmployee(UpdateEmployeeServiceDto updateEmployeeServiceDto, Long employeeCode)throws Exception;

	EmployeeDetails getEmployeeByCode(Long employeeCode);

	List<EmployeeDetailsDto> getAllEmployeeDetails(String employeeStatus, int pageNumber, int pageSize) throws Exception;

	String removeEmployee(Long employeeCode) throws Exception ;

}
