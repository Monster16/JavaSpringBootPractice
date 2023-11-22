package com.crud.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.crud.model.StudentInfo;
import com.crud.repository.CrudMysqlRepo;

@SpringBootTest
class CrudMysqlServiceImplTest {
	
	@Mock
	private CrudMysqlRepo crudMysqlRepo; 
	
	@InjectMocks
	private CrudMysqlServiceImpl crudMysqlServiceImpl;

	@Test
	void testfindAll() {
		StudentInfo student1 = new StudentInfo(1L, "Anil Singh", 25, 50000L);
        StudentInfo student2 = new StudentInfo(2L, "Amit Singh", 28, 60000L);
        
        List<StudentInfo> mockData = Arrays.asList(student1, student2);
		
		Mockito.when(crudMysqlRepo.findAll()).thenReturn(mockData);
		List<StudentInfo> studentInfo= crudMysqlServiceImpl.findAll();
		assertNotNull(studentInfo);
		assertThat(studentInfo).hasSize(2);
	}
	
	@Test
	void testAddStudent() {
		StudentInfo list = new StudentInfo(1L, "Anil", 26, 30000L);

		Mockito.when(crudMysqlRepo.save(Mockito.any())).thenReturn(list);
		StudentInfo studentInfo = crudMysqlServiceImpl.addStudent(list);
		assertNotNull(studentInfo);
	}
	
	@Test
	void testUpdateStudent() {
		StudentInfo list = new StudentInfo(1L, "Anil", 26, 30000L);

		Mockito.when(crudMysqlRepo.save(Mockito.any())).thenReturn(list);
		StudentInfo studentInfo = crudMysqlServiceImpl.updateStudentByuId(list);
		assertNotNull(studentInfo);
	}
	
	@Test
	void testDeleteStudent() {

		StudentInfo info = new StudentInfo();
		info.setsId(1L);
		info.setsName("Anil");
		info.setsAge(26);
		info.setsSalary(20000L);
		
//		doNothing().when(crudMysqlRepo).deleteById(Mockito.any());
		crudMysqlServiceImpl.deleteUserBysId(info.getsId());
		
		verify(crudMysqlRepo, times(1)).deleteById(eq(info.getsId()));
	}

}
