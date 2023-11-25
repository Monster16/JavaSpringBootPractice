package com.v1.departmentservice.serviceImpl;

import com.v1.departmentservice.dto.DepartmentDto;
import com.v1.departmentservice.entity.Department;
import com.v1.departmentservice.exception.ResourceNotFoundException;
import com.v1.departmentservice.repo.DepartmentRepository;
import com.v1.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert DepartmentDto to Department JPA entity
        /**
         *  Directly Converting DepartmentDto to Department JPA Entity
         */
//        Department department = new Department(
//                departmentDto.getId(),
//                departmentDto.getDepartmentName(),
//                departmentDto.getDepartmentDescription(),
//                departmentDto.getDepartmentCode()
//        );
        /**
         * Using Model Mapper
         */
        Department department = modelMapper.map(departmentDto,Department.class);
        Department saveDepartment = departmentRepository.save(department);
        //convert Department JPA Entity to DepartmentDto
        /**
         * Directly Converting Department JPA Entity to DepartmentDto
         */
//        DepartmentDto saveDepartmentDto = new DepartmentDto(
//                saveDepartment.getId(),
//                saveDepartment.getDepartmentName(),
//                saveDepartment.getDepartmentDescription(),
//                saveDepartment.getDepartmentCode()
//        );
        /**
         *  Using Model Mapper
         */
        DepartmentDto saveDepartmentDto = modelMapper.map(saveDepartment, DepartmentDto.class);

        return saveDepartmentDto;
    }

    @Override
    public DepartmentDto getByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.getByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department","departmentCode",departmentCode)
        );

        /**
         * Directly Converting Department JPA Entity to DepartmentDto
         */
//        DepartmentDto departmentDto = new DepartmentDto(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
