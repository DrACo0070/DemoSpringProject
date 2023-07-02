package com.bway.springDemo.service;

import java.util.List;

import com.bway.springDemo.model.Department;

public interface DepartmentService {
	
	void addDept(Department dept);
	
	void deleteDept(int id);
	
	void updateDept(Department dept);
	
	Department getDeptById(int id);
	
	List<Department> getAllDept();

}
