package com.employeeservice.exceptions;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value=EmployeeDetailsNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(EmployeeDetailsNotFoundException employeeDetailsNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorCode("Employee Details");
		errorMessage.setErrorMessage(employeeDetailsNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(EmployeeNotFoundException employeeNotFoundException){
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setErrorCode("Employee Details");
		errorMessage.setErrorMessage(employeeNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
		
	}
	/*
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
	Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
	String errorMessage = "";
	if (!violations.isEmpty()) {
	StringBuilder builder = new StringBuilder();
	violations.forEach(violation -> builder.append(" " + violation.getMessage()));
	errorMessage = builder.toString();
	} else {
	errorMessage = "ConstraintViolationException occured.";
	}
	return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
	*/
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException  argInvalidException, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorMessage response = new ErrorMessage();
		response.setErrorCode("125");
		String allFieldErrors = argInvalidException.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));
		response.setErrorMessage(allFieldErrors);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

}
