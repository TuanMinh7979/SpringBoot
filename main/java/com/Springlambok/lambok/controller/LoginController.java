package com.Springlambok.lambok.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Springlambok.lambok.entity.User;
import com.Springlambok.lambok.repo.UserRepo;
import com.Springlambok.lambok.util.HashUtil;

@Controller
public class LoginController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/login")
	public String getLoginForm() {

		return "auth/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userRepo.findByEmail1(email);
		HttpSession session = request.getSession();
		if (user == null) {
			session.setAttribute("error", "Email khong ton tai");

			return "redirect:/login";
		}
		boolean check = HashUtil.verify(password, user.getPassword());
		
		if (!check) {
			session.setAttribute("error", "Email khong ton tai");

			return "redirect:/login";
		}
		return "redirect:/users";

	}
}
