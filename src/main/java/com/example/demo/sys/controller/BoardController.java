package com.example.demo.sys.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.service.BoardService;

@Controller
public class BoardController {
	
	@Resource(name = "com.example.demo.sys.service.BoardService")
	BoardService mBoardService;

	@RequestMapping("/login")
	@GetMapping
	public String viewLogin(Model model) {
		// View attribute
		model.addAttribute("login_message", "社内図書管理システム");
		return "login";
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list");
		return "list";
	}
	
	@RequestMapping("/list") // 리스트화면호출
	private String MemberLogin(Model model) throws Exception {

		model.addAttribute("list", mBoardService.tosyoListService());
		return "list"; // JSP 생성
	}

	@RequestMapping("/detail/{tosyo_num}")
	private String tosyoDetail(@PathVariable int ts_numbers, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.tosyoDetailService(ts_numbers));
		return "detail";
	}

	@RequestMapping("/insert") // 도서등록폼호출
	private String tosyoInsertForm() {
		return "insert";
	}

	@RequestMapping("/insertProc")
	private String tosyoInsertProc(HttpServletRequest request) throws Exception {

		BoardVO tosyo_master = new BoardVO();
		
        tosyo_master.settosyo_num(request.getParameter("tosyo_num"));
		tosyo_master.settosyo_name(request.getParameter("tosyo_name"));
		tosyo_master.settosyo_daibunrui(request.getParameter("tosyo_daibunrui"));
		tosyo_master.settosyo_cyubunrui(request.getParameter("tosyo_cyubunrui"));

		mBoardService.tosyoInsertService(tosyo_master);

		return "redirect:/list";
	}

	@RequestMapping("/update/{tosyo_num}") // 게시글수정폼호출
	private String tosyoUpdateForm(@PathVariable int ts_numbers, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDeleteService(ts_numbers));

		return "update";
	}

	@RequestMapping("/updateProc")
	private int tosyoUpdateProc(HttpServletRequest request) throws Exception {
		BoardVO tosyo_master = (BoardVO) request.getParameterMap();

		return mBoardService.tosyoUpdateService(tosyo_master);
	}

	@RequestMapping("delete/{tosyo_num}")
	private String tosyoDelete(@PathVariable int ts_numbers) throws Exception {
		mBoardService.tosyoDeleteService(ts_numbers);

		return "redirect:/list";
	}

}
