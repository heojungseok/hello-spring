package com.hello.hellospring.controller;

public class MemberForm {

    private String name; //createMemberForm 안에 데이터를 받는 name 변수명과 동일하게

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
