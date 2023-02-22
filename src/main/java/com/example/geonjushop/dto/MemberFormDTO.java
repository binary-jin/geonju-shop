package com.example.geonjushop.dto;

import com.example.geonjushop.constant.GenderType;
import com.example.geonjushop.constant.MemberType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDTO { //회원가입 화면으로부터 넘어오는 정보 담을 객체

    @NotBlank
    private String memberId; //회원 아이디

    @NotBlank
    //@Pattern(regexp="[a-zA-Z1-9]{8,20}",
           // message = "비밀번호는 영어와 숫자로 포함해서 8~20자리 이내로 입력해주세요.")
    private String memberPwd; //회원 비밀번호

    @NotBlank
    private String memberName; //회원 이름

    @NotBlank
    private String memberPhone; //회원 전화번호

    @Email
    private String memberEmail;

    private String memberBirth;

//    @NotEmpty (message = "필수 선택입니다")
    private String memberGenderType;

}
