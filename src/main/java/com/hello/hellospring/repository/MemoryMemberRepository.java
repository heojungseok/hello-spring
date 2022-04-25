package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.*;
public class MemoryMemberRepository implements MemberRepository {
    //구현체
    //저장을 위한 map
    private static Map<Long, Member> store = new HashMap<>(); //
    private static long sequence = 0L; //키 값을 생성해줌

    @Override
    public Member save(Member member) {

        member.setId(++sequence); //시퀀스 값이 자동으로 올라갈 수 있게
        store.put(member.getId(), member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //store의 value 를 돌면서 member의 이름과 파라미터의 이름이 같으면 다 보여주는 명령어
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store.values() = member
    }

    //Test를 위한 메소드
    public void clearStore() {
        store.clear();
    }
}
