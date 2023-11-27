package com.v1.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    @Schema(
            description = "DepartmentName"
    )
    private String departmentName;
    @Schema(
            description = "DepartmentDescription"
    )
    private String departmentDescription;
    @Schema(
            description = "DepartmentCode"
    )
    private String departmentCode;
}

