package com.crud.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class StudentInfoTest {

	@Test
	void testStudentInfo() {
		StudentInfo info = new StudentInfo();
		info.setsId(1L);
		info.setsName("Anil");
		info.setsAge(26);
		info.setsSalary(20000L);

		info.getsId();
		info.getsName();
		info.getsAge();
		info.getsSalary();

		assertNotNull(info);
	}

	@Test
	public void testConstructor() {

		Long sId = 1L;
		String sName = "Anil";
		int sAge = 26;
		Long sSalary = 20000L;

		StudentInfo studentInfo = new StudentInfo(sId, sName, sAge, sSalary);

		assertNotNull(studentInfo);

	}

}
