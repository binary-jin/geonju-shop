package com.example.geonjushop.controller;

import com.example.geonjushop.dto.MemberFormDTO;
import com.example.geonjushop.entity.Member;
import com.example.geonjushop.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("MemberFormDto", new MemberFormDTO());
        return "join";
    }

    //회원가입 폼 작성
    //post 요청으로 넘어온 회원가입 정보를 memberformdto 객체로 받음
    @PostMapping("/joinform")
    public String memberJoin(@Valid MemberFormDTO memberFormDTO, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            return "join";
        }
        try{
            Member member = Member.createMember(memberFormDTO, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "join";
        }

        return "redirect:/geonju/"; //문제 없으면 메인페이지로
    }
}
