package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //멤버 객체 저장
    Optional<Member> findById(Long id); //id로 찾기
    Optional<Member> findByName(String name); //이름으로 찾기
    List<Member> findAll(); // 멤버 전체 리스트

}
