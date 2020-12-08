package com.employeeservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeeservice.dto.AddEmployeeServiceDto;
import com.employeeservice.dto.EmployeeDetailsDto;
import com.employeeservice.dto.UpdateEmployeeServiceDto;
import com.employeeservice.entity.EmployeeDetails;
import com.employeeservice.exceptions.EmployeeDetailsNotFoundException;
import com.employeeservice.exceptions.EmployeeNotFoundException;
import com.employeeservice.repository.EmployeeServiceRepository;
import com.employeeservice.repository.UpdateEmployeeServiceRepository;
import com.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeServiceRepository employeeServiceRepository;
	
	@Autowired
	UpdateEmployeeServiceRepository updateEmployeeServiceRepository;

	@Override
	public void addEmployee(AddEmployeeServiceDto employeeDetailsDto) {
		String status=employeeDetailsDto.getEmployeeStatus();
		
		List<EmployeeDetails> employee= new ArrayList<EmployeeDetails>();
		
		//for(EmployeeDetailsDto employeeDto :employeeDetailsDto) 
		employeeDetailsDto.getEmployeeDetailsDto().stream().forEach(employeeDto->{
			EmployeeDetails employeeDetails=new EmployeeDetails();
			BeanUtils.copyProperties(employeeDto, employeeDetails);
			employeeDetails.setEmployeeStatus(status);
			employee.add(employeeDetails);
			
		});
		
		employeeServiceRepository.saveAll(employee);
		
		logger.info("Employee Added Successfully.");

	}

	
	
	@Override
	public UpdateEmployeeServiceDto updateEmployee(UpdateEmployeeServiceDto updateEmployeeServiceDto, Long employeeCode) throws Exception {
		Optional<EmployeeDetails> employee;
		employee=updateEmployeeServiceRepository.findById(employeeCode);
		if(!employee.isPresent()) {
			logger.warn("There is no Record found of the Employee Code ");
			throw new EmployeeNotFoundException("EmployeeCode is not Active");
			
		}
			logger.info("The Employee details updated Successfully.");
		EmployeeDetails employeeInfo=employee.get();
		BeanUtils.copyProperties(updateEmployeeServiceDto, employeeInfo);
		
		UpdateEmployeeServiceDto updateService=new UpdateEmployeeServiceDto();
		BeanUtils.copyProperties(updateEmployeeServiceRepository.save(employeeInfo),updateService );
		return  updateService;
	}



	@Override
	public String removeEmployee(Long employeeCode) throws Exception{
		
		Optional<EmployeeDetails> employee=employeeServiceRepository.findById(employeeCode);
		if(!employee.isPresent()) {
			logger.warn("There is no Record found of the Employee Code");
			throw new EmployeeNotFoundException("EmployeeCode is not Active");
			
		}
			logger.info("The Employee status has been changed into InActive");
			
		EmployeeDetails employeeDetails=employee.get();
		/*
		if(employeeDetails.getEmployeeStatus()=="InActive") {
			throw new EmployeeNotFoundException("Employee is not Active");
			
		}
		*/
		employeeDetails.setEmployeeStatus("InActive");
		
		employeeServiceRepository.save(employeeDetails);
		
		return "Successfully deleted";
		
	}

	@Override
	public EmployeeDetails getEmployeeByCode(Long employeeCode) {
		
		return employeeServiceRepository.findByEmployeeCode(employeeCode);
	}

	@Override
	public List<EmployeeDetailsDto> getAllEmployeeDetails(String employeeStatus, int pageNumber, int pageSize)
				throws Exception{
		Page<EmployeeDetails> employeeDetails; 
		List<EmployeeDetailsDto> employeeDetailsList=new ArrayList<>();
		Pageable pageable= PageRequest.of(pageNumber, pageSize);
		employeeDetails=employeeServiceRepository.findByEmployeeStatus(employeeStatus,pageable);
		if(employeeDetails.isEmpty()) {
			logger.warn("No records Found");
			throw new EmployeeDetailsNotFoundException("No Employee details found");
		}
			logger.info("Employee's Details getting by paginatin");
		//for(EmployeeDetails employee:employeeDetails) 
		employeeDetails.stream().forEach(employee->{
			EmployeeDetailsDto employeeDetailsDto=new EmployeeDetailsDto();
			BeanUtils.copyProperties(employee, employeeDetailsDto);
			employeeDetailsList.add(employeeDetailsDto);
		});
		return employeeDetailsList;
	}

	

}
