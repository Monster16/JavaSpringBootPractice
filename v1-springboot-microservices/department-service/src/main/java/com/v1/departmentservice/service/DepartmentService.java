package com.v1.departmentservice.service;

import com.v1.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getByDepartmentCode(String departmentCode);
}
