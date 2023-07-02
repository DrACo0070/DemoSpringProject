package com.bway.springDemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.springDemo.model.User;
import com.bway.springDemo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String getSignin() {
		
		return "SignInForm";
	}
	
	@PostMapping("/signin")
	public String postSignin(@ModelAttribute User user, Model model, HttpSession session) {
		
		User usr = userService.signin(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser", usr);
			session.setMaxInactiveInterval(500);
			
			//model.addAttribute("uname", usr.getFname());
			return "Home";
		}
		
		model.addAttribute("message", "User not found !!");
		return "SignInForm";
	}
	
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignUpForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		
		userService.signup(user);
		
		return "SignInForm";
	}
	
	@GetMapping("/logout")
	private String logout(HttpSession session) {
		
		session.invalidate();
		
		return "SignInForm";
	}

}
