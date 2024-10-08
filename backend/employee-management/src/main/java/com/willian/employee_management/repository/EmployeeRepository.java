package com.willian.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.employee_management.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
