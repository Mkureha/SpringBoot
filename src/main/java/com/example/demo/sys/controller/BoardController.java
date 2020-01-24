package com.example.demo.sys.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.example.demo.sys.service.BoardService")
	BoardService mBoardService;

	@RequestMapping("/list") // 리스트화면호출
	private String tosyoList(Model model) throws Exception {

		model.addAttribute("list", mBoardService.tosyoListService());

		return "list"; // JSP 생성
	}

	@RequestMapping("/detail/{tosyo_num}")
	private String tosyoDetail(@PathVariable String tosyo_num, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDetailService(tosyo_num));

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
	private String tosyoUpdateForm(@PathVariable String tosyo_num, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDeleteService(tosyo_num));

		return "update";
	}

	@RequestMapping("/updateProc")
	private String tosyoUpdateProc(HttpServletRequest request) throws Exception {
		BoardVO tosyo_master = (BoardVO) request.getParameterMap();

		return mBoardService.tosyoUpdateService(tosyo_master);
	}

	@RequestMapping("delete/{tosyo_num}")
	private String tosyoDelete(@PathVariable String tosyo_num) throws Exception {
		mBoardService.tosyoDeleteService(tosyo_num);

		return "redirect:/list";
	}

}
