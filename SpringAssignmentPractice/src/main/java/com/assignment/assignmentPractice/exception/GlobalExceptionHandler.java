package com.assignment.assignmentPractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.assignmentPractice.handler.NotValidCreditCardHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NotValidCreditCardHandler.class)
	public ResponseEntity<?> notValidCreditCard(NotValidCreditCardHandler exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
		
	}
	
}
