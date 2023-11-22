package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.model.StudentInfo;

@Repository
public interface CrudMysqlRepo extends JpaRepository<StudentInfo, Long>{
	
//	StudentInfo findBysId(long sId);
	
	@Query(value = "SELECT MAX(e.s_id) From studentdb e", nativeQuery = true)
	 Long findMaxsId();

}
