package com.example.demo.sys.persistence;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.example.demo.sys.domain.member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//자세한 설명은 구글 검색 (너무 길어져서 생략)
@Repository
public class member_dao {
	// 싱글톤으로 선언된걸 주입 받음
	@Inject
	private SqlSession session;
	// 자신이 사용하고 싶은 mapper의 namespace 이름
	private static final String NameSpace = "memberMapper.";

	public int Id_Check(member m) {
		// 예외처리
		try {
			// 결과값을 반환
			return session.selectOne(NameSpace + "Id_Check", m);
		} catch (Exception e) {
			// 오류 발생시 오류 출력과 -1 반환
			e.printStackTrace();
			return -1;
		}
	}

	public int Register(member m) {
		// 위에 선언된 Id_Check(m)의 결과값을 Id_Check_Result에 담는다.
		int Id_Check_Result = Id_Check(m);
		// Id_Check_Result값이 0이 아니라면 Id_Check_Result값을 반환
		// 0은 아이디가 중복되지 않음 자세한거는 mapper를 열어보세요.
		if (Id_Check_Result != 0)
			return Id_Check_Result;

		try {
			// sqlsession에 insert를 할꺼고 내가 쓸 맵퍼는 위에 12번째줄에 선언된거고
			// 내가 사용 할 QUERY문은 Register를 사용하고 넘길 값은 m이다.
			// 이후 설명은 다 생략 똑같은 내용
			session.insert(NameSpace + "Register", m);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

	public int Login(member m, HttpSession Hsession) {
		int Id_Search_Result = -1;
		try {
			Id_Search_Result = session.selectOne(NameSpace + "Login", m);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		if (Id_Search_Result != 1)
			return Id_Search_Result;

		try {
			member m_info = session.selectOne(NameSpace + "Login_Info", m);
			Hsession.setAttribute("m", m_info);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -2;
		}
	}

}