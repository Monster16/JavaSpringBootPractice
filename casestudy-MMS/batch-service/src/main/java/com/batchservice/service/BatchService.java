package com.batchservice.service;

import java.util.List;

//import com.capg.batchservice.dto.APIResponseDto;
import com.batchservice.dto.BatchDto;

public interface BatchService {
 
	public BatchDto createBatch(BatchDto batchDto);
//	public BatchDto getBatchByBatchCode(String batchCode);
	public BatchDto getBatchByBatchId(Long batchId);
	public List<BatchDto> getAllBatch();
	public BatchDto updateBatchByBatchId(BatchDto batchDto);
//	public BatchDto updateBatch1(BatchDto batchDto);
//	public String deleteBatch1(String batchCode);
	public String deleteBatchByBatchId(Long batchID);
}