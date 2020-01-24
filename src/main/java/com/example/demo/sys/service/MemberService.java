package com.example.demo.sys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.sys.domain.MemberVO;
import com.example.demo.sys.mapper.MemberMapper;

@Service("com.example.demo.sys.service.MemberService")
public class MemberService {

	@Resource(name = "com.example.demo.sys.mapper.MemberMapper")
	MemberMapper mMemberMapper;

	public int MemberLoginService(MemberVO member) throws Exception {
		return mMemberMapper.MemberLogin(member);
	}

}
