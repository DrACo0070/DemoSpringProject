package com.bway.springDemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springDemo.model.User;
import com.bway.springDemo.repository.UserRepository;
import com.bway.springDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void signup(User user) {
		userRepo.save(user);
	}

	@Override
	public User signin(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un, psw);
	}

}
