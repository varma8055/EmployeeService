package com.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeservice.entity.EmployeeDetails;

public interface UpdateEmployeeServiceRepository extends JpaRepository<EmployeeDetails, Long>{

}
