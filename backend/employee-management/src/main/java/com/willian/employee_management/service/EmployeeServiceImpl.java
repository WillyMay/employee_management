package com.willian.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.employee_management.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import java.util.stream.Collectors;

import com.willian.employee_management.dto.*;
import com.willian.employee_management.entities.Employee;
import com.willian.employee_management.exception.ResourceNotFoundException;
import com.willian.employee_management.mapper.EmployeeMapper;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with id: " + employeeId));

        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());

        employeeRepository.save(existingEmployee);
        return EmployeeMapper.mapToEmployeeDto(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not exist with id: " + employeeId));

        employeeRepository.deleteById(employeeId);
    }
}
