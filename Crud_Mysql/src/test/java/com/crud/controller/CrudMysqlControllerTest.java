package com.crud.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crud.model.StudentInfo;
import com.crud.repository.CrudMysqlRepo;
import com.crud.service.CrudMysqlService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class CrudMysqlControllerTest {
	
	@InjectMocks
	private CrudMysqlController crudMysqlController;
	
	@Mock
	private CrudMysqlService crudMysqlService;
	
	@Mock
	private CrudMysqlRepo crudMysqlRepo; 
	
	@Mock
	private MockMvc mockMvc;
	
	@BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(crudMysqlController).build();
    }

	@Test
	void testGetAllStudents() throws Exception {
//		StudentInfo student1 = new StudentInfo(1L, "Anil Singh", 25, 50000L);
//        StudentInfo student2 = new StudentInfo(2L, "Amit Singh", 28, 60000L);
//        
        List<StudentInfo> list = new ArrayList<>();
        StudentInfo student1 = new StudentInfo();
        student1.setsId(1L);
        student1.setsName("Anil");
        student1.setsAge(26);
        student1.setsSalary(20000L);
        list.add(student1);
        
        Mockito.when(crudMysqlService.findAll()).thenReturn(list);
		this.mockMvc.perform(get("/api/allStudent")).andExpect(status().isOk());
	}
	
	@Test
	void testGetAllStudentsButDataIsEmpty() throws Exception {
		 List<StudentInfo> list = new ArrayList<>();
        Mockito.when(crudMysqlService.findAll()).thenReturn(list);
		this.mockMvc.perform(get("/api/allStudent")).andExpect(status().isNotFound());
	}
	
	@Test
	void testAddStudent() throws Exception {
		StudentInfo student1 = new StudentInfo(1L, "Anil Singh", 25, 50000L);
		
		Mockito.when(crudMysqlService.addStudent(any(StudentInfo.class))).thenReturn(student1);
		
		mockMvc.perform(post("/api/student/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	@Test
	void testUpdateStudent() throws Exception {
		StudentInfo student1 = new StudentInfo(1L, "Anil Singh", 25, 50000L);
		Mockito.when(crudMysqlRepo.existsById(Mockito.any())).thenReturn(true);
		Mockito.when(crudMysqlService.updateStudentByuId(any(StudentInfo.class))).thenReturn(student1);
		
		mockMvc.perform(put("/api/update/{sId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}
	
	@Test
	void testUpdateStudentIsMisMatch() throws Exception {
		StudentInfo student1 = new StudentInfo(2L, "Anil Singh", 25, 50000L);
		Mockito.when(crudMysqlRepo.existsById(Mockito.any())).thenReturn(true);
		Mockito.when(crudMysqlService.updateStudentByuId(any(StudentInfo.class))).thenReturn(student1);
		
		mockMvc.perform(put("/api/update/{sId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student1)))
                .andExpect(status().isBadRequest());

	}
	
	@Test
	void testUpdateStudentIdNotPresent() throws Exception {
		StudentInfo student1 = new StudentInfo(2L, "Anil Singh", 25, 50000L);
		Mockito.when(crudMysqlRepo.existsById(Mockito.any())).thenReturn(false);
		Mockito.when(crudMysqlService.updateStudentByuId(any(StudentInfo.class))).thenReturn(student1);
		
		mockMvc.perform(put("/api/update/{sId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(student1)))
                .andExpect(status().isNotFound());

	}
	
	

}
