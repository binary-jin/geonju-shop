package com.example.geonjushop.controller;

import com.example.geonjushop.dto.MemberFormDTO;
import com.example.geonjushop.entity.Member;
import com.example.geonjushop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/geonju")
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    //회원가입 페이지로 이동
    //get 요청으로 회원가입 페이지 요청할 경우 memberformdto 객체 같이 넘김
    @GetMapping("/joinform")
    public String join(Model model) {
        model.addAttribute("MemberFormDTO", new MemberFormDTO());
        return "join";
    }

    //중복 검사
    @PostMapping("/joinform/checkid")
    @ResponseBody
    public Object idDuplicated(@RequestBody MemberFormDTO memberFormDTO) {
        String memberId = memberFormDTO.getMemberId();
        memberService.validateDuplicateMember(memberId);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("res", true);
        return resultMap;
    }

    //회원가입 폼 작성
    //post 요청으로 넘어온 회원가입 정보를 memberformdto 객체로 받음
    @PostMapping("/joinform")
    @ResponseBody
    public Object memberJoin(@RequestBody MemberFormDTO memberFormDTO, Errors errors, Model model) {
        Member member = Member.createMember(memberFormDTO, passwordEncoder);
        memberService.saveMember(member);
        return member; //문제 없으면 메인페이지로
    }
}
