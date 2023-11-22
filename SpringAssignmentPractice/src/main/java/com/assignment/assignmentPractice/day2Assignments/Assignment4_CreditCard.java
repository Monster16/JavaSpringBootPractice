package com.assignment.assignmentPractice.day2Assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignmentPractice.service.Assignmnet_4_Service;



@RestController
@RequestMapping("/assignment4")
public class Assignment4_CreditCard {
	
	private Assignmnet_4_Service assignmnet_4_Service;
	
	@Autowired
	public Assignment4_CreditCard(Assignmnet_4_Service assignmnet_4_Service) {
		this.assignmnet_4_Service = assignmnet_4_Service;
	}
	
	@GetMapping("/validate/{creditCardNumber}")
	public ResponseEntity<Object> validateCreditCard(@PathVariable String creditCardNumber) {
		return ResponseEntity.ok(assignmnet_4_Service.validateCreditCard(creditCardNumber));
		
	}

}
