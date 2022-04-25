package com.hello.hellospring.domain;

import javax.persistence.*;

@Entity //JPA 가 관리하는 Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 생성
    private Long id; //데이터를 구분 및 저장 하기 위한 시스템상 임의의 값
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
