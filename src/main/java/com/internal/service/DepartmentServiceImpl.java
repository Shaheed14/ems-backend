package com.internal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.internal.dto.DepartmentDto;
import com.internal.entity.Department;
import com.internal.exception.ResourceNotFoundException;
import com.internal.mapper.DepartmentMapper;
import com.internal.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
   
  

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department=DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                            .orElseThrow(()->
                            new ResourceNotFoundException("Department not found by given id" + departmentId));
      
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((deprtment)->DepartmentMapper.mapToDepartmentDto(deprtment))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId)
                         .orElseThrow(()->
                         new ResourceNotFoundException("Department not found by given id" + departmentId));
        department.setDepartmentName(updatedDepartment.getDepartmentName()); 
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription()); 
        Department updateDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updateDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {

        Department department=departmentRepository.findById(departmentId)
                                .orElseThrow(()->
                                new ResourceNotFoundException("Department Not Found by Given ID "+ departmentId));
                departmentRepository.deleteById(departmentId);
    }
    
}
