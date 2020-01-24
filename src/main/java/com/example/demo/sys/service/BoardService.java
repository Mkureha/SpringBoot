package com.example.demo.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.mapper.BoardMapper;

@Service("com.example.demo.sys.service.BoardService")
public class BoardService {

	@Resource(name = "com.example.demo.sys.mapper.BoardMapper")
	BoardMapper mBoardMapper;

	public List<BoardVO> tosyoListService() throws Exception {
		return mBoardMapper.tosyoList();
	}

	public BoardVO tosyoDetailService(String tosyo_num) throws Exception {
		return mBoardMapper.tosyoDetail(tosyo_num);
	}

	public String tosyoInsertService(BoardVO tosyo_master) throws Exception {
		return mBoardMapper.tosyoInsert(tosyo_master);
	}

	public String tosyoUpdateService(BoardVO tosyo_master) throws Exception {
		return mBoardMapper.tosyoUpdate(tosyo_master);
	}

	public String tosyoDeleteService(String tosyo_num) throws Exception {
		return mBoardMapper.tosyoDelete(tosyo_num);
	}

}
