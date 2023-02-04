package com.example.geonjushop.dto;

import com.example.geonjushop.constant.GenderType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDTO {

    private String memberId;
    private String memberPwd;
    private String memberName;
    private String memberPhone;
    private String memberEmail;
    private int memberBirth;
    private GenderType memberGenderType;

}
