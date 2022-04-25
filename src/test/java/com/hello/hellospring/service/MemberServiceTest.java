package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository; //2. 보관

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository(); //1. MemoryMemberRepository() 생성
        memberService = new MemberService(memberRepository);//3. MemberService 에서 memberRepository를 인자로 받는 memberService에 memberRepository를 넣음
    }

    @AfterEach//테스트가 하나씩 끝날때마다 저장된 내용을 지우기 위한 곳(DB의 값 삭제)
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void join() {

        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);

        //then
        Member findmember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        //
        /*
         * assertThrows(예외가 발생해야 하는 클래스, () -> 검증할 로직) 람다형식
         * 오른쪽 로직을 실행이 될 때, 왼쪽 예외가 발생해야 하는 문법
         * */
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디 입니다");
    /*    try {
            memberService.join(member1);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디 입니다");
        }*/
        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}