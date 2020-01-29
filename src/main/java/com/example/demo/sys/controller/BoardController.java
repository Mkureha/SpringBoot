package com.example.demo.sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.domain.Paging;
import com.example.demo.sys.domain.User;
import com.example.demo.sys.mapper.BoardMapper;
import com.example.demo.sys.service.BoardService;

@Controller
public class BoardController {

	private static final BoardMapper mapper = null;
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

			return "redirect:/list";
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
	
	@RequestMapping("/ListPage")
	public String ListPage(HttpServletRequest request) {
		Paging paging = new Paging();
		String pagenum = request.getParameter("pagenum");
		String contentnum = request.getParameter("contentnum");
		int cpagenum = Integer.parseInt(pagenum);
		int ccontentnum = Integer.parseInt(contentnum);
		
		paging.setTotalcount(mapper.tosyocount()); //전체계수
		paging.setPagenum(cpagenum-1); //현재 페이지 객체 지정
		paging.setContentnum(ccontentnum); //한 페이지 게시글 수
		paging.setCurrentblock(cpagenum); //현재 페이지블록 번호
		paging.setLastblock(paging.getTotalcount()); // 마지막 블록 전체 게시글 수
		
		paging.prevnext(cpagenum); //현재 페이지 화살표
		paging.setStartpage(paging.getCurrentblock()); //시작페이지 블록 번호
		paging.setEndpage(paging.getLastblock(), paging.getCurrentblock()); //마지막 페이지 블럭 현재 페이지 블록
		
		List<BoardVO> tosyoList = new ArrayList<>();
		tosyoList = mapper.ListPage(paging.getPagenum()*10, paging.getContentnum());
		
		request.setAttribute("list", tosyoList);
		request.setAttribute("page", paging);
		
		return "list";
	}
	
	@RequestMapping("/detail/{tosyo_number}")
	private String tosyoDetail(@PathVariable int tosyo_number, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.tosyoDetailService(tosyo_number));
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

	@RequestMapping("/update/{tosyo_number}") // 게시글수정폼호출
	private String tosyoUpdateForm(@PathVariable int tosyo_number, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.tosyoDetailService(tosyo_number));

		return "update";
	}

	@PostMapping("/updateProc")
	private String tosyoUpdateProc(HttpServletRequest request) throws Exception {
		
		BoardVO tosyo_master = new BoardVO();
		
		tosyo_master.settosyo_num(request.getParameter("tosyo_num"));
		tosyo_master.settosyo_name(request.getParameter("tosyo_name"));
		tosyo_master.settosyo_daibunrui(request.getParameter("tosyo_daibunrui"));
		tosyo_master.settosyo_cyubunrui(request.getParameter("tosyo_cyubunrui"));
		tosyo_master.settosyo_number(Integer.parseInt(request.getParameter("tosyo_number")));
		
		mBoardService.tosyoUpdateService(tosyo_master);
		return "redirect:/detail/"+request.getParameter("tosyo_number");
	}

	@RequestMapping("delete/{tosyo_number}")
	private String tosyoDelete(@PathVariable int tosyo_number) throws Exception {
		mBoardService.tosyoDeleteService(tosyo_number);

		return "redirect:/list";
	}

}