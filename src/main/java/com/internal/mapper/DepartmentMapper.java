package com.internal.mapper;

import com.internal.dto.DepartmentDto;
import com.internal.entity.Department;

public class DepartmentMapper {

    //convert department jpa entity into departmentDto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription()
        );
    }

    //convert departmentDto into department jpa entity

    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription()
        );
    }


}
