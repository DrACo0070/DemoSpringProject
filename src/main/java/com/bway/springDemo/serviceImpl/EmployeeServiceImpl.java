package com.bway.springDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springDemo.model.Employee;
import com.bway.springDemo.repository.EmployeeRepository;
import com.bway.springDemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmp(Employee employee) {
		
		empRepo.save(employee);
	}

	@Override
	public void deleteEmp(Long id) {
		
		empRepo.deleteById(id);
	}

	@Override
	public void updateEmp(Employee employee) {
		
		empRepo.save(employee);
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return empRepo.findAll();
	}

}
