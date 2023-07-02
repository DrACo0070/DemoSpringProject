package com.bway.springDemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springDemo.model.Employee;
import com.bway.springDemo.service.DepartmentService;
import com.bway.springDemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/add")
	public String getEmployee(Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptList", deptService.getAllDept());
		
		return "EmployeeForm";
	}
	
	@PostMapping("/add")
	public String postEmployee(@ModelAttribute Employee employee) {
		
		empService.addEmp(employee);
		
		return "redirect:/employee/add";
	}
	
	@GetMapping("/list")
	public String list(Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("empList", empService.getAllEmps());
		
		return "EmployeeListForm";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptList", deptService.getAllDept());
		
		model.addAttribute("empModel", empService.getEmpById(id));
		
		return "EmployeeEditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Employee employee) {
		
		empService.updateEmp(employee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {
		
		empService.deleteEmp(id);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptList", deptService.getAllDept());
		
		model.addAttribute("empModel", empService.getEmpById(id));
		
		return "EmployeeViewForm";
	}

}
