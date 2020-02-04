package com.example.demo.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.sys.domain.BoardVO;
import com.example.demo.sys.domain.User;

@Repository("com.example.demo.sys.mapper.BoardMapper")
public interface BoardMapper {
	// 로그인
	public int login(User user) throws Exception;

	// 도서개수
	public int tosyocount();

	// 도서목록페이징
	public List<BoardVO> listpage(@Param("pagenum") int pagenum, @Param("contentnum") int contentnum,
			@Param("searchtype") String searchtype, @Param("keyword") String keyword);

	// 도서상세
	public BoardVO tosyoDetail(int tosyo_number) throws Exception;

	// 도서작성
	public int tosyoInsert(BoardVO tosyo_master) throws Exception;

	// 도서수정
	public int tosyoUpdate(BoardVO tosyo_master) throws Exception;

	// 도서삭제
	public int tosyoDelete(int tosyo_number) throws Exception;

}