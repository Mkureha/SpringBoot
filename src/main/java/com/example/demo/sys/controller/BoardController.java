package com.example.demo.sys.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.domain.User;
import com.example.demo.sys.mapper.BoardMapper;
import com.example.demo.sys.service.BoardService;

@Controller
public class BoardController {

	@Resource(name = "com.example.demo.sys.mapper.BoardMapper")
	BoardMapper mapper;
	@Resource(name = "com.example.demo.sys.service.BoardService")
	BoardService mBoardService;

	@RequestMapping("/login") // 로그인폼호출
	private String loginForm() {
		return "login";
	}

	@RequestMapping("/loginProc")
	@GetMapping
	private String login(HttpServletRequest request) throws Exception {

		User user = new User();

		user.setusername(request.getParameter("username"));
		user.setpassword(request.getParameter("password"));
		user.setauthority(request.getParameter("authority"));
		user.setenabled(request.getParameter("enabled"));

		mBoardService.loginService(user);

		return "redirect:list";
	}

	@RequestMapping("GS/list")
	@PostMapping
	public String list(HttpServletRequest request, @RequestParam(required = false) String searchtype,
			@RequestParam(required = false) String keyword) {
		BoardVO BoardVO = new BoardVO();
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");
		System.out.println("pagenum : " + pagenum);
		System.out.println("contentnum : " + contentnum);
		System.out.println("searchtype : " + searchtype);
		int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum = Integer.parseInt(contentnum);

		BoardVO.setsearchtype(searchtype);
		BoardVO.setkeyword(keyword);

		BoardVO.settotalcount(mapper.tosyocount(BoardVO.getsearchtype(), BoardVO.getkeyword())); // 전체계수
		BoardVO.setpagenum(cpagenum - 1); // 현재 페이지 객체 지정
		BoardVO.setcontentnum(ccontentnum); // 한 페이지 게시글 수
		BoardVO.setcurrentblock(cpagenum); // 현재 페이지블록 번호
		BoardVO.setlastblock(BoardVO.gettotalcount()); // 마지막 블록 전체 게시글 수

		BoardVO.prevnext(cpagenum); // 현재 페이지 화살표
		BoardVO.setstartpage(BoardVO.getcurrentblock()); // 시작페이지 블록 번호
		BoardVO.setendpage(BoardVO.getlastblock(), BoardVO.getcurrentblock()); // 마지막 페이지 블럭 현재 페이지 블록

		List<BoardVO> listpage = new ArrayList<BoardVO>();
		listpage = mapper.listpage(BoardVO.getpagenum() * 10, BoardVO.getcontentnum(), BoardVO.getsearchtype(),
				BoardVO.getkeyword());

		System.out.println("Parameter keyword : " + request.getParameter("keyword"));
		System.out.println("Board keyword : " + BoardVO.getkeyword());

		request.setAttribute("list", listpage);
		request.setAttribute("page", BoardVO);

		return "list";
	}

	@RequestMapping("GS/detail/{tosyo_number}")
	private String tosyoDetail(@PathVariable int tosyo_number, @ModelAttribute BoardVO page, Model model)
			throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDetailService(tosyo_number));
		return "detail";
	}

	@RequestMapping("GS/insert") // 도서등록폼호출
	private String tosyoInsertForm() {
		return "insert";
	}

	@RequestMapping("/insertProc")
	@GetMapping
	private String tosyoInsertProc(MultipartHttpServletRequest request) throws Exception {

		BoardVO tosyo_master = new BoardVO();

		tosyo_master.settosyo_num(request.getParameter("tosyo_num"));
		tosyo_master.settosyo_name(request.getParameter("tosyo_name"));
		tosyo_master.settosyo_daibunrui(request.getParameter("tosyo_daibunrui"));
		tosyo_master.settosyo_cyubunrui(request.getParameter("tosyo_cyubunrui"));
		tosyo_master.settosyo_count(Integer.parseInt(request.getParameter("tosyo_count")));
		

		mBoardService.tosyoInsertService(tosyo_master);

		return "redirect:GS/list?pagenum=1&contentnum=10&searchtype=tosyo_num&keyword=";
	}

	@RequestMapping("GS/update/{tosyo_number}") // 게시글수정폼호출
	private String tosyoUpdateForm(@PathVariable int tosyo_number, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDetailService(tosyo_number));

		return "update";
	}

	@PostMapping("/updateProc")
	@GetMapping
	private String tosyoUpdateProc(HttpServletRequest request) throws Exception {

		BoardVO tosyo_master = new BoardVO();

		tosyo_master.settosyo_num(request.getParameter("tosyo_num"));
		tosyo_master.settosyo_name(request.getParameter("tosyo_name"));
		tosyo_master.settosyo_daibunrui(request.getParameter("tosyo_daibunrui"));
		tosyo_master.settosyo_cyubunrui(request.getParameter("tosyo_cyubunrui"));
		tosyo_master.settosyo_number(Integer.parseInt(request.getParameter("tosyo_number")));

		mBoardService.tosyoUpdateService(tosyo_master);
		return "redirect:GS/detail/" + request.getParameter("tosyo_number");
	}

	@RequestMapping("GS/delete/{tosyo_number}")
	@GetMapping
	private String tosyoDelete(@PathVariable int tosyo_number) throws Exception {
		mBoardService.tosyoDeleteService(tosyo_number);

		return "redirect:GS/list?pagenum=1&contentnum=10&searchtype=tosyo_num&keyword=";
	}

}