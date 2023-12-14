package com.batchservice.entity;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class BatchTest {
 
	@Test
    public void testBatchGetterAndSetter() {
        Batch batch = new Batch();
        batch.setBatchId(1L);
        batch.setBatchName("AWS");
        batch.setBatchCode("AWS01");
        batch.setTotalStudents(5);
 
        assertEquals(1L, batch.getBatchId());
        assertEquals("AWS", batch.getBatchName());
        assertEquals("AWS01", batch.getBatchCode());
        assertEquals(5, batch.getTotalStudents());
    }
	 @Test
	    public void testDefaultConstructor() {
	        Batch batch = new Batch();
 
	        assertNull(batch.getBatchId());
	        assertNull(batch.getBatchName());
	        assertNull(batch.getBatchCode());
	        assertNull(batch.getTotalStudents());
	        
	    }
 
	    @Test
	    public void testParameterizedConstructor() {
	        Long batchId = 1L;
	        String batchName = "AWS";
	        String batchCode = "AWS01";
	        int totalStudents = 5;
 
	        Batch batch = new Batch(batchId, batchName, batchCode, totalStudents);
 
	        assertEquals(batchId, batch.getBatchId());
	        assertEquals(batchName, batch.getBatchName());
	        assertEquals(batchCode, batch.getBatchCode());
	        assertEquals(totalStudents, batch.getTotalStudents());
	    }
}
 
