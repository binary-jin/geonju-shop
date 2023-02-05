package com.example.geonjushop.service;

import com.example.geonjushop.constant.GenderType;
import com.example.geonjushop.constant.MemberType;
import com.example.geonjushop.dto.MemberFormDTO;
import com.example.geonjushop.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
//@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    //@Autowired
    PasswordEncoder passwordEncoder;

    //controller에서 Post 입력값을 기반으로 memberFormDto 객 생성 예정
    public Member createMember() {
        MemberFormDTO memberFormDTO = new MemberFormDTO();
        memberFormDTO.setId(1L);
        memberFormDTO.setMemberId("abcd");
        memberFormDTO.setMemberPwd("1234");
        memberFormDTO.setMemberName("홍길동");
        memberFormDTO.setMemberPhone("010-1234-5678");
        memberFormDTO.setMemberBirth("2000.04.22");
        memberFormDTO.setMemberEmail("abcd@email.com");
        memberFormDTO.setMemberGenderType("man");
        memberFormDTO.setMemberType(MemberType.USER);

        return Member.createMember(memberFormDTO, passwordEncoder);
    }

    @Test
    public void saveMemberTest() {
        Member member = createMember();
        Member saveMember = memberService.saveMember(member);

        assertEquals(member.getId(), saveMember.getId());
        assertEquals(member.getMemberId(), saveMember.getMemberId());
        assertEquals(member.getMemberPwd(), saveMember.getMemberPwd());
        assertEquals(member.getMemberName(), saveMember.getMemberName());
        assertEquals(member.getMemberPhone(), saveMember.getMemberPhone());
        assertEquals(member.getMemberBirth(), saveMember.getMemberBirth());
        assertEquals(member.getMemberEmail(), saveMember.getMemberEmail());
        assertEquals(member.getGenderType(), saveMember.getGenderType());
        assertEquals(member.getMemberType(), saveMember.getMemberType());
    }

}