package com.assignment.assignmentPractice.day2Assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignmentPractice.entity.LocationInfo;
import com.assignment.assignmentPractice.service.Assignment_3_Service;

@RestController
@RequestMapping("/assignment3")
public class Assignment3_Zipcode {
	
	private Assignment_3_Service assignment_3_Service;
	
	@Autowired
	public Assignment3_Zipcode(Assignment_3_Service assignment_3_Service) {
		this.assignment_3_Service = assignment_3_Service;
	}
	
	@GetMapping("/getInfo/{zip}")
	public ResponseEntity<Object> getAddress(@PathVariable String zip) {
		LocationInfo locationInfo = assignment_3_Service.getData(zip);
		if(locationInfo != null) {
			return ResponseEntity.ok(locationInfo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not available for the provided zipcode");
		}
			
		
	}

}
