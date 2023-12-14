package com.mentors.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

	private Long batchId;
	private String batchName;
	private String batchCode;
	private int totalStudents;

}
