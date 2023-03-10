package com.example.geonjushop.entity;

import com.example.geonjushop.constant.GenderType;
import com.example.geonjushop.constant.MemberType;
import com.example.geonjushop.dto.MemberFormDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
//@Data
public class Member { //회원 정보 저장

    @Id
    @Column(nullable = false, length = 20)
    private String memberId; //사용자 아이디

    @Column(nullable = false, length = 20)
    private String memberPwd; //사용자 비밀번호

    @Column(nullable = false, length = 15)
    private String memberName; //사용자 이름

    @Column(nullable = false, length = 11)
    private String memberPhone; //사용자 전화번호

    @Column(length = 30)
    private String memberEmail; //사용자 이메일

    private String memberBirth; //사용자 생년월일

    //@Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private String genderType;  //사용자 성별

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING) //enum을 저장하는 방식
    private MemberType memberType;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberCount; //Auto_increment

//    @CreationTimestamp
//    private Timestamp createDate;   // 가입일

    //Member 객체를 생성하기 위해 Member 객체 안에 createMember() 메소드 생성
    public static Member createMember(MemberFormDTO memberFormDTO, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setMemberId(memberFormDTO.getMemberId());
        String memberPwd = passwordEncoder.encode(memberFormDTO.getMemberPwd()); //비밀번호 암호화
        member.setMemberPwd(memberPwd);
        member.setMemberName(memberFormDTO.getMemberName());
        member.setMemberPhone(memberFormDTO.getMemberPhone());
        member.setMemberEmail(memberFormDTO.getMemberEmail());
        member.setMemberBirth(memberFormDTO.getMemberBirth());
        member.setGenderType(memberFormDTO.getMemberGenderType());
        member.setMemberType(MemberType.USER);
        //member.setCreateDate(LocalDateTime.now());

        return member;
    }

}
