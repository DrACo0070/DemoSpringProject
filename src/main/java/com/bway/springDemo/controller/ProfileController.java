package com.bway.springDemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String getProfile(HttpSession session) {
		
		if(session.getAttribute("validuser") == null) {
			
			return "SignInForm";
		}
		
		return "ProfileForm";
	}

}
