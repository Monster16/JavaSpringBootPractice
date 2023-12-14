package com.batchservice.dto;

import java.time.LocalDate;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "MentorDto model information"
		)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {
	private Long batchId;
	
	@Schema(
			description = "Batch Name"
			)
	@NotEmpty(message = "Batch Name should not be null or empty ")
	private String batchName;

	@Schema(
			description = "Batch Code"
			)
	@NotEmpty(message = "Batch Code should not be null or empty ")
	private String batchCode;
	@Schema(
			description = "Total number of Students in Batch"
			)
	@NotNull(message = "Total Number of should not be null")
	private Integer totalStudents;
}
