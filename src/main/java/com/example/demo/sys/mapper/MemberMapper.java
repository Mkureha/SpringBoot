package com.example.demo.sys.mapper;

import org.springframework.stereotype.Repository;
import com.example.demo.sys.domain.MemberVO;

@Repository("com.example.demo.sys.mapper.MemberMapper")
public interface MemberMapper {
	// 로그인
	public int MemberLogin(MemberVO member) throws Exception;
}