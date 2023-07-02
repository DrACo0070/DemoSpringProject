package com.bway.springDemo.service;

import com.bway.springDemo.model.User;

public interface UserService {
	
	void signup(User user);
	
	User signin(String un, String psw);

}
