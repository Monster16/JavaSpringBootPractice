package com.assignment.assignmentPractice.day_2.Assignments.AssignmentService.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.assignmentPractice.day_2.Assignments.AssignmentService.Assignment_2_Service;

@Service
public class Assignment_2_ServiceImpl implements Assignment_2_Service {
	
	private final Map<String, String> userDatabase;
	
	public Assignment_2_ServiceImpl() {
		userDatabase = new HashMap<>();
		userDatabase.put("Anil", "1234");
		userDatabase.put("Singh", "123");
	}
	

	@Override
	public boolean isValidUser(String user, String pass) {
		System.out.println(user + " " + pass);
		// TODO Auto-generated method stub
		return userDatabase.containsKey(user) && userDatabase.get(user).equals(pass);
		
	}

}
