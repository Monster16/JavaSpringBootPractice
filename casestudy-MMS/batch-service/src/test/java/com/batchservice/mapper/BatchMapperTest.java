package com.batchservice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.batchservice.dto.BatchDto;
import com.batchservice.entity.Batch;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
//import org.junit.Test;

public class BatchMapperTest {

    @Test
    public void testMapToBatchDto() {
        // Create a sample Batch entity
        Batch batch = new Batch(1L, "AWS","AWS01",5);

        // Map the Batch entity to BatchDto
        BatchDto batchDto = BatchMapper.mapToBatchDto(batch);

        // Assert that the mapping is correct
        assertEquals(batch.getBatchId(), batchDto.getBatchId());
        assertEquals(batch.getBatchName(), batchDto.getBatchName());
        assertEquals(batch.getBatchCode(), batchDto.getBatchCode());
        assertEquals(batch.getTotalStudents(), batchDto.getTotalStudents());
    }

    @Test
    public void testMapToBatch() {
        // Create a sample BatchDto
        BatchDto batchDto = new BatchDto(1L, "AWS", "AWS01",5);

        // Map the BatchDto to Batch entity
        Batch batch = BatchMapper.mapToBatch(batchDto);

        // Assert that the mapping is correct
        assertEquals(batchDto.getBatchId(), batch.getBatchId());
        assertEquals(batchDto.getBatchName(), batch.getBatchName());
        assertEquals(batchDto.getBatchCode(), batch.getBatchCode());
        assertEquals(batchDto.getTotalStudents(), batch.getTotalStudents());
    }
}

