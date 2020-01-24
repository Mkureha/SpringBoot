package com.example.demo.sys.domain;

public class MemberVO {

	private String user_name;
	private String password;
	private String authority;

	public String getauthority() {
		return authority;
	}

	public void setauthority(String authority) {
		this.authority = authority;
	}

	public String getuser_name() {
		return user_name;
	}

	public void setusername(String user_name) {
		this.user_name = user_name;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
}