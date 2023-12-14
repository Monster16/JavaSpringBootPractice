package com.batchservice.controller;

import java.util.List;

import com.batchservice.dto.BatchDto;
import com.batchservice.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
 
@Tag(name = "Batch-Service - MentorController", description = "Batch Controller Exposes REST APIs for Batch-Service")
@RestController
@RequestMapping("api/batch")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class BatchController {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchController.class);

	@Autowired
	private BatchService batchService;


	@PostMapping("/createBatch")
	public ResponseEntity<BatchDto> createBatch(@RequestBody @Valid BatchDto batchDto) {
		LOGGER.info("Inside Controller of createBatch Method");
		BatchDto savedBatch = batchService.createBatch(batchDto);
		return new ResponseEntity<>(savedBatch, HttpStatus.CREATED);
	}


//	@Operation(summary = "Get Batch By Code REST API", description = "Get batch By REST API is used to get a batch object from the database")
//	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
//	@GetMapping("code/{batchCode}")
//	public ResponseEntity<BatchDto> getBatchByBatchCode(@PathVariable String batchCode) {
//		LOGGER.info("Inside Controller of getBatchByBatchCode Method");
//		BatchDto batch = batchService.getBatchByCode(batchCode);
//		return new ResponseEntity<>(batch, HttpStatus.OK);
//	}


	@Operation(summary = "Get Batch By ID REST API", description = "Get batch By REST API is used to get a batch object from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@GetMapping("{batchId}")
	public ResponseEntity<BatchDto> getBatchById(@PathVariable Long batchId) {
		LOGGER.info("Inside Controller of getBatchById Method");
		BatchDto batch = batchService.getBatchByBatchId(batchId);
		return new ResponseEntity<>(batch, HttpStatus.OK);
	}


	@Operation(summary = "Get batch By REST API", description = "Get batch By REST API is used to get a batch object from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@GetMapping("/getAllBatch")
	public ResponseEntity<List<BatchDto>> getAllBatch() {
		LOGGER.info("Inside Controller of getAllBatch Method");
		List<BatchDto> batch = batchService.getAllBatch();
		return new ResponseEntity<>(batch, HttpStatus.OK);
	}


//	@Operation(summary = "Put batch By REST API",
//			description = "put batch By REST API is used to update a batch object from the database")
//	@ApiResponse(responseCode = "200",
//	description = "HTTP Status 200 SUCCESS")
//	@PutMapping("code/{batchCode}")
//	public ResponseEntity<BatchDto> updateBatchByBatchCode(@PathVariable String batchCode, @RequestBody @Valid  BatchDto batchDto){
//		LOGGER.info("Inside Controller of updateBatchByBatchCode Method");
//		batchDto.setBatchCode(batchCode);
//		BatchDto updateBatch = batchService.updateBatch(batchDto);
//		return new ResponseEntity<BatchDto>(updateBatch, HttpStatus.OK);
//	}


	@Operation(summary = "Put batch By REST API", 
			description = "put batch By REST API is used to update a batch object from the database")
	@ApiResponse(responseCode = "200", 
	description = "HTTP Status 200 SUCCESS")
	@PutMapping("{batchId}")
	public ResponseEntity<BatchDto> updateBatchByBatchId(@PathVariable Long batchId,
			@RequestBody @Valid BatchDto batchDto) {
		LOGGER.info("Inside Controller of updateBatchByBatchId Method");
		batchDto.setBatchId(batchId);
		BatchDto updateBatch = batchService.updateBatchByBatchId(batchDto);
		return new ResponseEntity<BatchDto>(updateBatch, HttpStatus.OK);
	}


//	@Operation(summary = "Delete batch By code REST API", description = "Delete batch By REST API is used to delete a batch  from the database")
//	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
//	@DeleteMapping("code/{batchCode}")
//	public ResponseEntity<String> deleteBatchByBatchCode(@PathVariable String batchCode){
//		LOGGER.info("Inside Controller of deleteBatchByBatchCode Method");
//		batchService.deleteBatch1(batchCode);
//		return new ResponseEntity<String>("Batch deleted successfully!!!", HttpStatus.OK);
//	}


	@Operation(summary = "Delete batch By ID REST API", description = "Delete batch By REST API is used to delete a batch  from the database")
	@ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
	@DeleteMapping("{batchId}")
	public ResponseEntity<String> deleteBatchByBatchId(@PathVariable Long batchId) {
		LOGGER.info("Inside Controller of deleteBatchByBatchId Method");
		batchService.deleteBatchByBatchId(batchId);
		return new ResponseEntity<String>("Batch deleted successfully!!!", HttpStatus.OK);
	}
}