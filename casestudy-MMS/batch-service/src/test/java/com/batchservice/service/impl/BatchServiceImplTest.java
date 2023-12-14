package com.batchservice.service.impl;

import com.batchservice.dto.BatchDto;
import com.batchservice.entity.Batch;
import com.batchservice.mapper.BatchMapper;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.batchservice.exception.ResourceNotFoundException;
import com.batchservice.repository.BatchRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
public class BatchServiceImplTest {
 
    @InjectMocks
    private BatchServiceImpl batchService;
 
    @Mock
    private BatchRepository batchRepository;
 
   
//	@BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
 
    @BeforeEach
    public void setUp() {
        batchRepository = mock(BatchRepository.class);
        batchService = new BatchServiceImpl(batchRepository);
    }
    @Test
    public void testCreateBatch() {
        BatchDto batchDto = new BatchDto(1L,"AWS","AWS01",5);
        Batch batch = BatchMapper.mapToBatch(batchDto);
        when(batchRepository.save(any())).thenReturn(batch);
 
        BatchDto savedBatchDto = batchService.createBatch(batchDto);
 
        assertNotNull(savedBatchDto);
        // Add more assertions as needed
    }


    @Test
    public void testGetAllBatch() {
        when(batchRepository.findAll()).thenReturn(Collections.emptyList());
 
        List<BatchDto> batchList = batchService.getAllBatch();
 
        assertNotNull(batchList);
        assertEquals(0, batchList.size());
        // Add more assertions as needed
    }
 

    @Test
    public BatchDto updateBatch(BatchDto batchDto) throws ResourceNotFoundException {
        Optional<Batch> optionalBatch = batchRepository.findById(batchDto.getBatchId());

        if (optionalBatch.isPresent()) {
            Batch existingBatch = optionalBatch.get();

            // Update batch details
            existingBatch.setBatchName(batchDto.getBatchName());
            existingBatch.setBatchCode(batchDto.getBatchCode());
            existingBatch.setTotalStudents(batchDto.getTotalStudents());

            // Save and return updated batch
            Batch updatedBatch = batchRepository.save(existingBatch);
            return BatchMapper.mapToBatchDto(updatedBatch);
        } else {
            throw new ResourceNotFoundException("Batch", "batchId", batchDto.getBatchId());
        }
    }

}
