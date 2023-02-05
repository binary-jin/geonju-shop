package com.example.geonjushop.dto;

import com.example.geonjushop.constant.GenderType;
import com.example.geonjushop.constant.MemberType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MemberFormDTO {

    @GeneratedValue //auto increase
    private Long id; //회원 고유 번호

    @NotBlank(message = "필수 입력 값입니다")
    private String memberId; //회원 아이디

    @NotBlank(message = "필수 입력 값입니다")
    @Pattern(regexp="[a-zA-Z1-9]{8,20}",
            message = "비밀번호는 영어와 숫자로 포함해서 8~20자리 이내로 입력해주세요.")
    private String memberPwd; //회원 비밀번호

    @NotBlank(message = "필수 입력 값입니다")
    private String memberName; //회원 이름

    @NotBlank(message = "필수 입력 값입니다")
    private String memberPhone; //회원 전화번호

    @Email(message = "이메일 형식으로 입력해주세요")
    private String memberEmail;

    private String memberBirth;

    @NotEmpty (message = "필수 선택입니다")
    private String memberGenderType;

    private MemberType memberType;

}
