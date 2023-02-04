package com.example.geonjushop.repository;

import com.example.geonjushop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(String memberId);
    //회원가입 시 중복 여부를 판단하기 위해 아이디로 회원 중복 검사
}
