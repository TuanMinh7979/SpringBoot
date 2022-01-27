package com.Springlambok.lambok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springlambok.lambok.entity.User;
import com.Springlambok.lambok.repo.UserRepo;

@Service
public class AddUserService {

	// dung ra day se la 1 interface, ta chi NEN AUTOWIRED INTERFACE MA THOI
	@Autowired
	private UserRepo userRepo;


	public User findByEmail1(String email) {
		User user=userRepo.findByEmail1(email);
		return user;
	}

	
	public User findByEmail(String email) {
		User user=userRepo.findByEmail1(email);
		return user;
	}

}
