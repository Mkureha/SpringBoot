package com.example.demo.sys.domain;

public class User {

	private String user_name;
	private String password;
	private String authority;

	public User() {
	}

	public User(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public String getuser_name() {
		return user_name;
	}

	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	public String getauthority() {
		return authority;
	}

	public void setauthority(String authority) {
		this.authority = authority;
	}

}