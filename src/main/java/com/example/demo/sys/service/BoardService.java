package com.example.demo.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.domain.User;
import com.example.demo.sys.mapper.BoardMapper;

@Service("com.example.demo.sys.service.BoardService")
public class BoardService {

	@Resource(name = "com.example.demo.sys.mapper.BoardMapper")
	BoardMapper mBoardMapper;

	public int loginService(User member) throws Exception {
		return mBoardMapper.login(member);
	}

	public BoardVO tosyoDetailService(int tosyo_number) throws Exception {
		return mBoardMapper.tosyoDetail(tosyo_number);
	}

	public int tosyoInsertService(BoardVO tosyo_master) throws Exception {
		return mBoardMapper.tosyoInsert(tosyo_master);
	}

	public int tosyoUpdateService(BoardVO tosyo_master) throws Exception {
		return mBoardMapper.tosyoUpdate(tosyo_master);
	}

	public int tosyoDeleteService(int tosyo_number) throws Exception {
		return mBoardMapper.tosyoDelete(tosyo_number);
	}

	public List<BoardVO> listpage(int pagenum, int contentnum, String searchtype, String keyword) {
		return mBoardMapper.listpage(pagenum, contentnum, searchtype, keyword);
	}

	public int tosyocount() {
		return mBoardMapper.tosyocount();
	}
}