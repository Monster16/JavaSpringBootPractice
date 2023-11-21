package com.assignment.assignmentPractice.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.assignmentPractice.entity.LocationInfo;
import com.assignment.assignmentPractice.service.Assignment_3_Service;


@Service
public class Assignment_3_ServiceImpl implements Assignment_3_Service{
	
	private final Map<String, LocationInfo> locationInfoMap;
	
	public Assignment_3_ServiceImpl() {
		locationInfoMap = new HashMap<String, LocationInfo>();
		locationInfoMap.put("400604", new LocationInfo("Maharashtra", "Thane", "India"));
		locationInfoMap.put("212730", new LocationInfo("UP", "Basti", "India"));
	}
	
	

	@Override
	public LocationInfo getData(String zip) {
		// TODO Auto-generated method stub
		return locationInfoMap.get(zip);
	}

}
