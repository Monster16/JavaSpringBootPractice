package com.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "studentdb")
public class StudentInfo {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "s_Id",unique = true,nullable = false)
	private long sId;
	
	
	@Column(name= "s_Name", nullable = false)
	private String sName; 
	
	@Column(name= "s_Age", nullable = false)
	private int sAge; 
	
	@Column(name= "s_Salary", nullable = false)
	private Long sSalary;
	
	 @JsonProperty("sId")
	public long getsId() {
		return sId;
	}

	@JsonIgnore
	public void setsId(long sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

	public Long getsSalary() {
		return sSalary;
	}

	public void setsSalary(Long sSalary) {
		this.sSalary = sSalary;
	}

	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(Long sId, String sName, int sAge, Long sSalary) {

		this.sId = sId;
		this.sName = sName;
		this.sAge = sAge;
		this.sSalary = sSalary;
	}

}
