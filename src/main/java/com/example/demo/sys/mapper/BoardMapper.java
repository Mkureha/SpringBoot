package com.example.demo.sys.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.sys.domain.BoardVO;

@Repository("com.example.demo.sys.mapper.BoardMapper")
public interface BoardMapper {
	//도서개수
	public int tosyoCount() throws Exception;
	//도서목록
	public List<BoardVO> tosyoList() throws Exception;
	//도서상세
	public BoardVO tosyoDetail(int tosyo_num) throws Exception;
	//도서작성
	public String tosyoInsert(BoardVO tosyo_master) throws Exception;
	//도서수정
	public String tosyoUpdate(BoardVO tosyo_master) throws Exception;
	//도서삭제
	public String tosyoDelete(int tosyo_num) throws Exception;
}
