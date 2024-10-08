package com.willian.employee_management.service;

import java.util.List;

import com.willian.employee_management.dto.EmployeeDto;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto getEmployeeById(Long employee);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);
}
