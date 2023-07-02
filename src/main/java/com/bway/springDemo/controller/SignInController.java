package com.bway.springDemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springDemo.model.User;
import com.bway.springDemo.repository.UserRepository;

@Controller
public class SignInController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/signin")
	public String getSignin() {
		
		return "SignInForm";
		
	}
								//Model is used to carry value from controller to view. 
	@PostMapping("/signin")		//User is used to bind value from view to its pojo. 
	public String postSignin(@ModelAttribute User user, Model model, HttpSession session) {
		
		User usr = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser", usr);
			session.setMaxInactiveInterval(300);
			
			//model.addAttribute("uname", user.getUsername());
			
			return "Home";
		}
		
		model.addAttribute("message", "User not found !!");
		return "SignInForm";
	}

}
