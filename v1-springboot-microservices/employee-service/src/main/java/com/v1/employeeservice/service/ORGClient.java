package com.v1.employeeservice.service;

import com.v1.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
//@FeignClient(url = "http://localhost:8083" ,value = "DEPARTMENT-SERVICE")
public interface ORGClient {

    @GetMapping("/api/organizations/{code}")
    DepartmentDto getOrganization(@PathVariable("code") String organizationCode);
}
