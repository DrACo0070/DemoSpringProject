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

import com.bway.springDemo.model.Department;
import com.bway.springDemo.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/add")
	public String getDept(HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		return "DepartmentForm";
	}
	
	@PostMapping("/add")
	public String postDept(@ModelAttribute Department dept) {
		
		deptService.addDept(dept);
		
		return "DepartmentForm";
	}
	
	@GetMapping("/list")
	public String getAll(Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptList", deptService.getAllDept());
		
		return "DepartmentListForm";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id, Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptObject", deptService.getDeptById(id));
		
		return "DepartmentEditForm";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Department dept) {
		
		deptService.addDept(dept);
		
		return "redirect:/department/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		
		deptService.deleteDept(id);
		
		return "redirect:/department/list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam int id, Model model, HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		model.addAttribute("deptObject", deptService.getDeptById(id));
		
		return "DepartmentViewForm";
	}

}
