package com.crud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.StudentInfo;
import com.crud.repository.CrudMysqlRepo;
import com.crud.service.CrudMysqlService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CrudMysqlServiceImpl implements CrudMysqlService{
	
	@Autowired
	private CrudMysqlRepo crudMysqlRepo;

	@Override
	public List<StudentInfo> findAll() {
		// TODO Auto-generated method stub
		log.info("INSIDE SERVICEIMPL FINDING ALLSTUDENTS INFO: {}");
		return crudMysqlRepo.findAll();
	}

//	@Override
//	public Optional<StudentInfo> findBysId(Long sId) {
//		// TODO Auto-generated method stub
//		
//		return crudMysqlRepo.findById(sId);
//	}

	@Override
	public StudentInfo addStudent(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		log.info("INSIDE SERVICEIMPL ADDING STUDENT: {}");
		if(!crudMysqlRepo.existsById(studentInfo.getsId())) {
		studentInfo.setsId(generateUniqueID());
		}
		return crudMysqlRepo.save(studentInfo);
	}

	@Override
	public StudentInfo updateStudentByuId(StudentInfo studentInfo) {
		// TODO Auto-generated method stubY
		log.info("INSIDE SERVICEIMPL UPDATING STUDENT: {}");
		return crudMysqlRepo.save(studentInfo);
	}

	@Override
	public void deleteUserBysId(Long sId) {
		// TODO Auto-generated method stub
		log.info("INSIDE SERVICEIMPL DELETING STUDENT: {}");
		crudMysqlRepo.deleteById(sId);
		
	}
	
	private long generateUniqueID() {
	    Long sId = crudMysqlRepo.findMaxsId();
	    return (sId != null) ? sId + 1 : 1;
	  }
	

}
