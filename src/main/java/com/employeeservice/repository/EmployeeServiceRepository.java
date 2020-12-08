package com.employeeservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeservice.dto.EmployeeDetailsDto;
import com.employeeservice.entity.EmployeeDetails;
@Repository
public interface EmployeeServiceRepository extends JpaRepository<EmployeeDetails, Long> {

	EmployeeDetails findByEmployeeCode(Long employeeCode);

	Page<EmployeeDetails> findByEmployeeStatus(String employeeStatus, Pageable pageable);

}
