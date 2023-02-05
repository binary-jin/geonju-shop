package com.example.geonjushop.entity;

import com.example.geonjushop.constant.GenderType;
import com.example.geonjushop.constant.MemberType;
import com.example.geonjushop.dto.MemberFormDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk, Auto_increment

    @Column(nullable = false, length = 20)
    private String memberId; //사용자 아이디

    @Column(nullable = false, length = 20)
    private String memberPwd; //사용자 비밀번호

    @Column(nullable = false, length = 15)
    private String memberName; //사용자 이름

    @Column(nullable = false, length = 11)
    private String memberPhone; //사용자 전화번호

    @Column(nullable = false, length = 30)
    private String memberEmail; //사용자 이메일

    @Column(nullable = false)
    private String memberBirth; //사용자 생년월일

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private String genderType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //enum을 저장하는 방식
    private MemberType memberType;

//    @CreationTimestamp
//    private Timestamp createDate;   // 가입일

    public static Member createMember(MemberFormDTO memberFormDTO, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setMemberId(memberFormDTO.getMemberId());
        String memberPwd = passwordEncoder.encode(memberFormDTO.getMemberPwd()); //비밀번호 암호화
        member.setMemberPwd(memberPwd);
        member.setMemberName(memberFormDTO.getMemberName());
        member.setMemberEmail(memberFormDTO.getMemberEmail());
        member.setMemberBirth(memberFormDTO.getMemberBirth());
        member.setGenderType(memberFormDTO.getMemberGenderType());
        member.setMemberType(MemberType.USER);

        return member;
    }

}
