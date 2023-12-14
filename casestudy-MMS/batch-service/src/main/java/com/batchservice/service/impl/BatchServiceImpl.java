package com.batchservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.batchservice.dto.BatchDto;
import com.batchservice.entity.Batch;
import com.batchservice.mapper.BatchMapper;
import com.batchservice.service.BatchService;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.batchservice.exception.ResourceNotFoundException;
import com.batchservice.repository.BatchRepository;

import lombok.AllArgsConstructor;
 
@Service
@AllArgsConstructor
public class BatchServiceImpl implements BatchService {
 
	private BatchRepository batchRepository;
	
	@Override
	public BatchDto createBatch(BatchDto batchDto) {
		Batch batch = BatchMapper.mapToBatch(batchDto);
		Batch savedBatch = batchRepository.save(batch);
		BatchDto savedBatchDto = BatchMapper.mapToBatchDto(savedBatch);
		return savedBatchDto;
	}

//	@Override
//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDafaultStudent")
//	public APIResponseDto getBatchByCode(String batchCode) {
//		Batch batch = batchRepository.findByBatchCode(batchCode);
////				.orElseThrow(() -> new ResourceNotFoundException("Batch", "batchCode", batchCode));
//		List<StudentDto> studentDto = webClient.get()
//				.uri("http://localhost:8083/api/student/code/" +batch.getBatchCode())
//				.retrieve()
//				.bodyToMono(StudentDto.class)
//				.block();
//		
//		BatchDto batchDto = BatchMapper.mapToBatchDto(batch);
//		APIResponseDto apiResponseDto = new APIResponseDto();
//	      apiResponseDto.setBatch(batchDto);
//	      apiResponseDto.setStudent(studentDto);
//	      return apiResponseDto;
////		BatchDto batchDto = BatchMapper.mapToBatchDto(batch);
////		return batchDto;
//	}
	
	@Override
	public BatchDto getBatchByBatchId(Long batchId) throws ResourceNotFoundException {
		Batch batch = batchRepository.findById(batchId)
				.orElseThrow(() -> new ResourceNotFoundException("Batch", "batchCode", batchId));
		BatchDto batchDto = BatchMapper.mapToBatchDto(batch);
		return batchDto;
	}

	@Override
	public List<BatchDto> getAllBatch() {
		List<Batch> batch = batchRepository.findAll();
		return batch.stream().map(BatchMapper::mapToBatchDto).collect(Collectors.toList());
	}
 

	@Override
		public BatchDto updateBatchByBatchId(BatchDto batchDto) throws ResourceNotFoundException {
			Batch batch1 = batchRepository.findById(batchDto.getBatchId())
					.orElseThrow(() -> new ResourceNotFoundException("Batch", "batchCode", batchDto.getBatchId()));
			batch1.setBatchName(batchDto.getBatchName());
			batch1.setBatchCode(batchDto.getBatchCode());
			batch1.setTotalStudents(batchDto.getTotalStudents());
			Batch updatedBatch = batchRepository.save(batch1);
			return BatchMapper.mapToBatchDto(updatedBatch);
		}


	@Override
	public String deleteBatchByBatchId(Long batchID) throws ResourceNotFoundException {
		Batch batch = batchRepository.findById(batchID).get();
		batchRepository.deleteById(batchID);
		return "Deleted Successfully!!";
	}
 
}
 




