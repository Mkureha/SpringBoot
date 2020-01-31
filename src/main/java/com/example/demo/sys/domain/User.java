package com.example.demo.sys.domain;

public class User {

	private String username;
    private String password;
	private String authority;
    private String enabled;
    
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
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
	public String getenabled() {
		return enabled;
	}
	public void setenabled(String enabled) {
		this.enabled = enabled;
	}
	public static User findByUserusernameAndpassword(String getusername, String getpassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
