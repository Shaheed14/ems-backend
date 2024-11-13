package com.internal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.dto.EmployeeDto;
import com.internal.entity.Department;
import com.internal.entity.Employee;
import com.internal.exception.ResourceNotFoundException;
import com.internal.mapper.EmployeeMapper;
import com.internal.repository.DepartmentRepository;
import com.internal.repository.EmployeeRepository;



@Service

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;



	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Department department=departmentRepository.findById(employeeDto.getDepartmentId())
								.orElseThrow(()-> 
								new ResourceNotFoundException("Department is not exists with ID: "+ employeeDto.getDepartmentId()));
		employee.setDepartment(department);
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}


	@Override
	public EmployeeDto getEmployeeById(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
						.orElseThrow(()-> 
							new ResourceNotFoundException("Employee not found by given ID "+ employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
					new ResourceNotFoundException("Employee Not Found by given ID "+ employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Department department=departmentRepository.findById(updatedEmployee.getDepartmentId())
								.orElseThrow(()-> 
								new ResourceNotFoundException("Department is not exists with ID: "+updatedEmployee.getDepartmentId()));
		employee.setDepartment(department);
		
		Employee updateEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updateEmployee);
	}


	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(()-> 
					new ResourceNotFoundException("Employee not found by given ID "+ employeeId));
		employeeRepository.deleteById(employeeId);
		
	}
	

}
