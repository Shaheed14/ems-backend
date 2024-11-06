package com.internal.service;


import java.util.List;

import com.internal.dto.DepartmentDto;


public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    // EmployeeDto getEmployeeById(long employeeId);
	
	// List<EmployeeDto> getAllEmployees();
	
	// EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	
	// void deleteEmployee(Long employeeId);

    DepartmentDto getDepartmentById(Long departmentId);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
    void deleteDepartment(Long departmentId);
}
