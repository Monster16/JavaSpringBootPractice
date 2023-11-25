package com.v1.employeeservice.serviceImpl;

import com.v1.employeeservice.dto.EmployeeDto;
import com.v1.employeeservice.entity.Employee;
import com.v1.employeeservice.mapper.AutoEmployeeMapper;
import com.v1.employeeservice.repo.EmployeeRepository;
import com.v1.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        /**
         * Directly Converting EmployeeDto to Employee JPA Entity
         */
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );
        /**
         * Using Model Mapper
         */
//        Employee employee = modelMapper.map(employeeDto, Employee.class);

        /**
         * Using Map Struct
         */
        Employee employee = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);

        /**
         *   Directly Converting Employee JPA Entity to EmployeeDto
         */
//        EmployeeDto saveEmployeeDto = new EmployeeDto(
//                saveEmployee.getId(),
//                saveEmployee.getFirstName(),
//                saveEmployee.getLastName(),
//                saveEmployee.getEmail()
//        );

        /**
         * Using Model Mapper
         */
//        EmployeeDto saveEmployeeDto = modelMapper.map(saveEmployee, EmployeeDto.class);

        /**
         * Using Map Struct
         */
        EmployeeDto saveEmployeeDto = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDto(saveEmployee);

        return saveEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        /**
         * Directly Converting EmployeeDto to Employee JPA Entity
         */
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );
        /**
         * Using Model Mapper
         */
//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        /**
         * Using Map Struct
         */
        EmployeeDto employeeDto = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDto(employee);
        return employeeDto;
    }
}
