package com.example.demo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String viewLogin(Model model) {
		// View attribute
		model.addAttribute("login_message", "社内図書管理システム");
		return "login";
	}
	
}