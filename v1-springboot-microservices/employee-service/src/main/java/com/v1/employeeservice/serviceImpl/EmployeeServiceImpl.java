package com.v1.employeeservice.serviceImpl;

import com.v1.employeeservice.dto.APIResponseDto;
import com.v1.employeeservice.dto.DepartmentDto;
import com.v1.employeeservice.dto.EmployeeDto;
import com.v1.employeeservice.entity.Employee;
import com.v1.employeeservice.exception.ResourceNotFoundException;
import com.v1.employeeservice.mapper.AutoEmployeeMapper;
import com.v1.employeeservice.repo.EmployeeRepository;
import com.v1.employeeservice.service.APIClient;
import com.v1.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper;

//    private RestTemplate restTemplate;

    private WebClient webClient;

//    private APIClient apiClient;

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

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        /**
         * Microservice call via RestTemplate
         */
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
//                "http://localhost:8081/api/departments/get/" +employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
        /**
         * Microservice Call via WebClient
         */
        DepartmentDto departmentDto = webClient.get()
                .uri("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        /**
         * Microservice Call via Feign Client
         */
//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
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
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = AutoEmployeeMapper.AUTO_EMPLOYEE_MAPPER.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
