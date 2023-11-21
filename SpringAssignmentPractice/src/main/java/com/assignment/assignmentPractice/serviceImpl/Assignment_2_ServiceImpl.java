package com.assignment.assignmentPractice.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.assignmentPractice.service.Assignment_2_Service;


@Service
public class Assignment_2_ServiceImpl implements Assignment_2_Service{
	
	private final Map<String, String> userDatabase;
	
	public Assignment_2_ServiceImpl(){
		userDatabase = new HashMap<>();
		userDatabase.put("Anil", "1234");
		userDatabase.put("Singh", "12345");
	}

	@Override
	public boolean isValidUser(String user, String pass) {
		// TODO Auto-generated method stub
		return userDatabase.containsKey(user) && userDatabase.get(user).equals(pass);
	}

}
