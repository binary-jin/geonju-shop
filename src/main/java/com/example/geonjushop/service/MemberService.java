package com.example.geonjushop.service;

import com.example.geonjushop.entity.Member;
import com.example.geonjushop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입 저장
    public Member saveMember(Member member) {
        //validateDuplicateMember(member);
        Optional<Member> memberOptional = memberRepository.findByMemberId(member.getMemberId());
        if (memberOptional.isPresent()) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

        return memberRepository.save(member);
    }

    //회원 중복 검사
    public void validateDuplicateMember(String memberId) {
        Optional<Member> findMemberOptional = memberRepository.findByMemberId(memberId);
        if (findMemberOptional.isPresent()) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

}
