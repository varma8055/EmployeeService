package com.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.dto.AddEmployeeServiceDto;
import com.employeeservice.dto.EmployeeDetailsDto;
import com.employeeservice.dto.UpdateEmployeeServiceDto;
import com.employeeservice.entity.EmployeeDetails;
import com.employeeservice.service.EmployeeService;

@RestController
public class EmployeeServiceController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String>  addEmployee(@RequestBody @Valid AddEmployeeServiceDto employeeDetailsDto ) {
		
		employeeService.addEmployee(employeeDetailsDto);
		return new ResponseEntity<String>("Employee Added Successfully",HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<UpdateEmployeeServiceDto> updateEmployee(@RequestBody UpdateEmployeeServiceDto updateEmployeeServiceDto,  @RequestParam Long employeeCode) throws Exception {
		  
		  return new ResponseEntity<UpdateEmployeeServiceDto>(employeeService.updateEmployee(updateEmployeeServiceDto,employeeCode),HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getByEmployeeDetails/{employeeCode}")
	public ResponseEntity<EmployeeDetails> getEmployeeByCode(@PathVariable  Long employeeCode) {
		
		return new ResponseEntity<EmployeeDetails>(employeeService.getEmployeeByCode(employeeCode),HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllEmployeeDetails")
	public ResponseEntity<List<EmployeeDetailsDto>> getAllEmployeeDetails(@RequestParam String employeeStatus, @RequestParam int pageNumber, @RequestParam int pageSize) throws Exception {
		
		 return new ResponseEntity<List<EmployeeDetailsDto>>(employeeService.getAllEmployeeDetails(employeeStatus,pageNumber,pageSize),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeEmployee")
	public ResponseEntity<String> removeEmployee(@RequestParam Long employeeCode) throws Exception  {
		return new ResponseEntity<String>(employeeService.removeEmployee(employeeCode),HttpStatus.CONTINUE);
		
	}
	

}
