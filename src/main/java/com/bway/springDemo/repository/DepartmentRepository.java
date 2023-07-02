package com.bway.springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springDemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
