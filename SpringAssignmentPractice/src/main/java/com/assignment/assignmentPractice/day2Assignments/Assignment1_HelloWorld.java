package com.assignment.assignmentPractice.day2Assignments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/assignment1")
public class Assignment1_HelloWorld {

	@GetMapping("/greet")
	public ResponseEntity<Object> sayHallo() {
		return new ResponseEntity<Object>("HelloWorld", HttpStatus.OK);
	}

}
