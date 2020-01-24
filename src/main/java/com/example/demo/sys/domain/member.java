package com.example.demo.sys.domain;

public class member {
    //해당 클래스에서 m_id, m_pw를 선언
    private String userId;
    private String password;
    
    //Stirng값을 반환하는 get_M_id 메소드
    public String getuserId() {
        //해당하는 클레스의 전역변수로 선언된 m_id를 반환한다.
        return userId;
    }
    //반환값이 없는 setM_id 매개변수는 Stirng m_id를 가진다.
    public void setuserId(String userId) {
        //전역 변수에 있는 m_id에 매개변수로 받은 m_id를 담는다.
        this.userId = userId;
    }
    
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
}