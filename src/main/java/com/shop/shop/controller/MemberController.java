package com.shop.shop.controller;

import com.shop.shop.dto.JoinFormDto;
import com.shop.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/new")
    public String memberJoinForm(JoinFormDto joinFormDto, Model model) {
        model.addAttribute("joinFormDto", joinFormDto);
        return "member/joinForm";
    }


}
