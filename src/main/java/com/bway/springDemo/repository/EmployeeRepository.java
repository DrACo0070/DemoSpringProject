package com.bway.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springDemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
