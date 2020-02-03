package com.example.demo.sys.domain;

public class Search extends BoardVO{
	
	private String searchtype;
	private String keyword;	
			
	public String getsearchtype() {
		return searchtype;
	}
	
	public void setsearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	public String getkeyword() {
		return keyword;
	}

	public void setkeyword(String keyword) {
		this.keyword = keyword;
	}

}