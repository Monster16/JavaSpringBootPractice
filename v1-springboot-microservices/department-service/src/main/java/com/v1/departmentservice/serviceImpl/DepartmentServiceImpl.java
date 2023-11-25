package com.v1.departmentservice.serviceImpl;

import com.v1.departmentservice.dto.DepartmentDto;
import com.v1.departmentservice.entity.Department;
import com.v1.departmentservice.repo.DepartmentRepository;
import com.v1.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert DepartmentDto to Department JPA entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department saveDepartment = departmentRepository.save(department);
        //convert Department JPA Entity to DepartmentDto
        DepartmentDto saveDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.getByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
