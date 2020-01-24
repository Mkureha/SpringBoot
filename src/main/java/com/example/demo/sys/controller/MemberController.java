package com.example.demo.sys.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sys.domain.MemberVO;
import com.example.demo.sys.service.MemberService;

@Controller
public class MemberController {

	@Resource(name = "com.example.demo.sys.service.MemberService")
	MemberService mMemberService;

	@RequestMapping("/login") // 도서등록폼호출
	private String MemberLoginForm() {
		return "login";
	}
	
	@RequestMapping("/loginProc")
	private String MemberLoginProc(HttpServletRequest request) throws Exception {

		MemberVO member = new MemberVO();

		member.setusername(request.getParameter("user_name"));
		member.setpassword(request.getParameter("password"));

		mMemberService.MemberLoginService(member);

		return "redirect:/login";
	}

}
