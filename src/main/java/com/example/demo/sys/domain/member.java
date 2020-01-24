package com.example.demo.sys.domain;

public class member {
    //해당 클래스에서 m_id, m_pw를 선언
    private String m_id;
    private String m_pw;
    
    //Stirng값을 반환하는 get_M_id 메소드
    public String getM_id() {
        //해당하는 클레스의 전역변수로 선언된 m_id를 반환한다.
        return m_id;
    }
    //반환값이 없는 setM_id 매개변수는 Stirng m_id를 가진다.
    public void setM_id(String m_id) {
        //전역 변수에 있는 m_id에 매개변수로 받은 m_id를 담는다.
        this.m_id = m_id;
    }
    
    public String getM_pw() {
        return m_pw;
    }
    public void setM_pw(String m_pw) {
        this.m_pw = m_pw;
    }
}