package com.Springlambok.lambok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Springlambok.lambok.entity.User;

@Controller
public class HomeController {
	@GetMapping("/")

	
	public String hello() {
	System.out.println("hello everyone");
		return "hello";
	}


}
