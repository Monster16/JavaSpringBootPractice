package com.v1.departmentservice.controller;

import com.v1.departmentservice.dto.DepartmentDto;
import com.v1.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Department",
        description = "REST APIs - Create, Get"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    /**
     * Create Department
     * http://localhost:8080/api/departments/create
     * @param departmentDto
     * @return
     */
    @Operation(
            summary = "Create Department Rest API",
            description = "Create Department Rest API is used to save Department in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
    }

    /**
     * GetByDepartmentCode
     * http://localhost:8080/api/departments/{department-code}
     * @param departmentCode
     * @return
     */
    @Operation(
            summary = "GET Department BY CODE Rest API",
            description = "GET Department BY CODE Rest API is used to GET Department FROM database"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "HTTP Status 20O SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto =  departmentService.getByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
