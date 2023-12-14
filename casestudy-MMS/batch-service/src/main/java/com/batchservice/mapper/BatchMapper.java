package com.batchservice.mapper;

import com.batchservice.dto.BatchDto;
import com.batchservice.entity.Batch;

public class BatchMapper {

	//convert JPA Entity to DTO
	public static BatchDto mapToBatchDto(Batch batch) {
		BatchDto batchDto = new BatchDto(
				batch.getBatchId(),
				batch.getBatchName(),
				batch.getBatchCode(),
				batch.getTotalStudents()
				);
		return batchDto;
	}
	
	public static Batch mapToBatch(BatchDto batchDto) {
		Batch batch = new Batch(
				batchDto.getBatchId(),
				batchDto.getBatchName(),
				batchDto.getBatchCode(),
				batchDto.getTotalStudents()
				);
		return batch;
	}
}
