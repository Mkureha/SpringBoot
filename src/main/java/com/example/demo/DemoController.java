package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@RequestMapping("/SB")
	@ResponseBody
	public String home() {
		// TODO Auto-generated method stub
		return "Hi Spring Boot!!";
	}

}
