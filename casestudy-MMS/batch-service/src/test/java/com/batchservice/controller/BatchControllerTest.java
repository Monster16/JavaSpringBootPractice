package com.batchservice.controller;


import static org.junit.jupiter.api.Assertions.*;

import com.batchservice.dto.BatchDto;
import com.batchservice.service.BatchService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BatchControllerTest {

    private BatchController batchController;
    private BatchService batchService;

    @BeforeEach
    public void setUp() {
        batchService = mock(BatchService.class);
        batchController = new BatchController(batchService);
    }

    //used Mockito to mock the BatchService and set it up in the setUp method.
    //The test cases then use this mocked service to simulate interactions with the actual service.
    @Test
    public void testCreateBatch() {
        BatchDto batchDto = new BatchDto(1L, "AWS", "AWS01", 5);
        when(batchService.createBatch(batchDto)).thenReturn(batchDto);

        ResponseEntity<BatchDto> responseEntity = batchController.createBatch(batchDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(batchDto, responseEntity.getBody());
        verify(batchService, times(1)).createBatch(batchDto);
    }


    @Test
    public void testGetAllBatch() {
        List<BatchDto> batchList = Collections.singletonList(new BatchDto(1L, "AWS","AWS01", 5));
        when(batchService.getAllBatch()).thenReturn(batchList);

        ResponseEntity<List<BatchDto>> responseEntity = batchController.getAllBatch();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(batchList, responseEntity.getBody());
        verify(batchService, times(1)).getAllBatch();
    }


    @Test
    public void testUpdateBatch1() {
        Long batchId = 1L;
        BatchDto batchDto = new BatchDto(1L, "AWS", "AWS01", 5);
        when(batchService.updateBatchByBatchId(batchDto)).thenReturn(batchDto);

        ResponseEntity<BatchDto> responseEntity = batchController.updateBatchByBatchId(batchId, batchDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(batchDto, responseEntity.getBody());
        verify(batchService, times(1)).updateBatchByBatchId(batchDto);
    }

    @Test
    public void testDeleteBatch() {
        Long batchId = 1L;

        ResponseEntity<String> responseEntity = batchController.deleteBatchByBatchId(batchId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Batch successfully deleted!!", responseEntity.getBody());
        verify(batchService, times(1)).deleteBatchByBatchId(batchId);
    }
}

