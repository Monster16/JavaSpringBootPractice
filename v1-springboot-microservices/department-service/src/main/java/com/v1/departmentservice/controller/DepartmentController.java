package com.v1.departmentservice.controller;

import com.v1.departmentservice.dto.DepartmentDto;
import com.v1.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    /**
     * Create Department
     * http://localhost:8081/api/departments/create
     * @param departmentDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartmentDto, HttpStatus.CREATED);
    }

    /**
     * GetByDepartmentCode
     * http://localhost:8081/api/departments/get/{department-code}
     * @param departmentCode
     * @return
     */
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto =  departmentService.getByDepartmentCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

}
