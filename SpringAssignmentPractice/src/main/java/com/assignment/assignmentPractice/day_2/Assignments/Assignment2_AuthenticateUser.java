package com.assignment.assignmentPractice.day_2.Assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignmentPractice.day_2.Assignments.AssignmentService.Assignment_2_Service;
import com.assignment.assignmentPractice.entity.UserCredential;

@RestController
@RequestMapping("/assignment2")
public class Assignment2_AuthenticateUser {
	
	private Assignment_2_Service assignment_2_Service;

	@Autowired
	public Assignment2_AuthenticateUser( Assignment_2_Service assignment_2_Service) {
		this.assignment_2_Service = assignment_2_Service;
	};

	@PostMapping("/authenticate")
	public ResponseEntity<Object> authenticate(@RequestBody UserCredential userCredential) {

		 System.out.println("Received request: " + userCredential.getUser() + "/" + userCredential.getPass());
		 
		if (assignment_2_Service.isValidUser(userCredential.getUser(), userCredential.getPass())) {
			 System.out.println("Valid user");
			return new ResponseEntity<>("Valid User!!!", HttpStatus.OK);
		} else {
			 System.out.println("Invalid user");
			return new ResponseEntity<>("Invalid User!!!", HttpStatus.UNAUTHORIZED);
		}

	}

}
