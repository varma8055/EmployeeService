package com.employeeservice.exceptions;

public class EmployeeDetailsNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeDetailsNotFoundException(String message) {
		super(message);
	}
	
	public EmployeeDetailsNotFoundException(String message,Throwable t) {
		super(message, t);
	}

}
