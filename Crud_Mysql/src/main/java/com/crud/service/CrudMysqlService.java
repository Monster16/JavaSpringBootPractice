package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.model.StudentInfo;

public interface CrudMysqlService {
	

	List<StudentInfo> findAll();
	
//	Optional<StudentInfo> findBysId(Long sId);
	
	StudentInfo addStudent(StudentInfo studentInfo);
	
	StudentInfo updateStudentByuId(StudentInfo studentInfo);
	
	void deleteUserBysId(Long sId);

}
