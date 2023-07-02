package com.bway.springDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springDemo.model.Department;
import com.bway.springDemo.repository.DepartmentRepository;
import com.bway.springDemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public void addDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public void deleteDept(int id) {
		deptRepo.deleteById(id);
	}

	@Override
	public void updateDept(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public Department getDeptById(int id) {
		
		return deptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDept() {
		
		return deptRepo.findAll();
	}

}