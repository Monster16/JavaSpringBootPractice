package com.assignment.assignmentPractice.entity;

public class LocationInfo {
	
	private String state;
	private String city;
	private String country;
	
	

	public LocationInfo(String state, String city, String country) {
		super();
		this.state = state;
		this.city = city;
		this.country = country;
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
