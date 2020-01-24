package com.example.demo.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class MemberController {

	@GetMapping
	public String MemberLogin(Model model) {
		model.addAttribute("login_message", "図書管理システム");
		return "login";
	}
}