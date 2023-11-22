package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.StudentInfo;
import com.crud.repository.CrudMysqlRepo;
import com.crud.service.CrudMysqlService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class CrudMysqlController {

	@Autowired
	private CrudMysqlService crudMysqlService;

	@Autowired
	private CrudMysqlRepo crudMysqlRepo;

	@GetMapping("/allStudent")
	private ResponseEntity<Object> getAllStudents() {

		List<StudentInfo> list = crudMysqlService.findAll();
		if (!list.isEmpty()) {
		log.info("INSIDE IF FINDING ALLSTUDENTS INFO: {}");
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} else {
			log.error("INSIDE ELSE BLOCK SOMETHING WENT WRONG!!!");
			return new ResponseEntity<Object>("OPPS!!! SOMETHING WENT WRONG", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path ="/student/addStudent" , consumes = {MediaType.APPLICATION_JSON_VALUE},produces ={MediaType.APPLICATION_JSON_VALUE})
	private ResponseEntity<?> addStudent(@RequestBody StudentInfo studentInfo) {
		    log.info("INSIDE  ADDING STUDENT: {}");
			return ResponseEntity.status(HttpStatus.OK).body( crudMysqlService.addStudent(studentInfo));
	}
	
	@PutMapping("/update/{sId}")
	private ResponseEntity<Object> updateUserByuId(@RequestBody StudentInfo studentInfo, @PathVariable long sId) {
		
			boolean isStudentExistsById = crudMysqlRepo.existsById(sId);
			if (isStudentExistsById) {
				log.info("INSIDE IF BLOCK CHECKING STUDENT ID: {}");
				if (studentInfo.getsId() == sId) {
					log.info("INSIDE IF BLOCK OF IF BLOCK UPDATING STUDENT: {}");
					crudMysqlService.updateStudentByuId(studentInfo);
					return new ResponseEntity<Object>(studentInfo, HttpStatus.OK);
				} else {
					log.info("INSIDE IF BLOCK OF ELSE BLOCK UID MISMATCH: {}");
					return new ResponseEntity<Object>("UID MISMATCH {}", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.info("INSIDE ELSE BLOCK STUDENT NOT FOUND WITH THIS ID: {}");
				return new ResponseEntity<Object>("STUDENT NOT FOUND WITH THIS ID {} " + sId, HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping("/delete/{sId}")
	private ResponseEntity<Object> deleteStudentBySId(@PathVariable long sId) {

		boolean isStudentExistsById = crudMysqlRepo.existsById(sId);
		if (isStudentExistsById) {
			log.info("INSIDE IF BLOCK DELETING STUDENT: {}");
			crudMysqlService.deleteUserBysId(sId);
			return new ResponseEntity<Object>("STUDENT DELETED WITH THIS SID {} " + sId, HttpStatus.OK);
		} else {
			log.info("INSIDE ELSE BLOCK STUDENT NOT FOUND WITH THIS SID: {}");
			return new ResponseEntity<Object>("STUDENT NOT FOUND WITH THIS SID {} " + sId, HttpStatus.NOT_FOUND);
		}
	}

}
