package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

    
    
}
