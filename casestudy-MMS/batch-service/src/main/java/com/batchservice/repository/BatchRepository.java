package com.batchservice.repository;

import com.batchservice.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface BatchRepository extends JpaRepository<Batch, Long>{

	@Transactional
	Batch findByBatchCode(String batchCode);
	
	@Transactional
	void deleteByBatchCode(String batchCode);
}
