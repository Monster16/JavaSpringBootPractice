package com.assignment.assignmentPractice.day_2.Assignment_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class Assignment1_HelloWorld {

	@GetMapping("/hello")
	public String sayHallo() {
		return "Hello-World";
	}

}
