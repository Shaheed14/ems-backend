package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
