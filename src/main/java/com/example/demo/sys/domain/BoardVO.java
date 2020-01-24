package com.example.demo.sys.domain;
 
public class BoardVO {

	private String tosyo_num;
    private String tosyo_name;
	private String tosyo_daibunrui;
    private String tosyo_cyubunrui;
    
	public String gettosyo_num() {
		return tosyo_num;
	}
	public void settosyo_num(String tosyo_num) {
		this.tosyo_num = tosyo_num;
	}
	public String gettosyo_name() {
		return tosyo_name;
	}
	public void settosyo_name(String tosyo_name) {
		this.tosyo_name = tosyo_name;
	}
	public String gettosyo_daibunrui() {
		return tosyo_daibunrui;
	}
	public void settosyo_daibunrui(String tosyo_daibunrui) {
		this.tosyo_daibunrui = tosyo_daibunrui;
	}
	public String gettosyo_cyubunrui() {
		return tosyo_cyubunrui;
	}
	public void settosyo_cyubunrui(String tosyo_cyubunrui) {
		this.tosyo_cyubunrui = tosyo_cyubunrui;
	}
}