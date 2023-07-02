package com.bway.springDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springDemo.model.User;
import com.bway.springDemo.repository.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
	private UserRepository userRepo; //use of repository in controller
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignUpForm";
		
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		
		userRepo.save(user); //save to db
		
		return "SignInForm";
		
	}

}
