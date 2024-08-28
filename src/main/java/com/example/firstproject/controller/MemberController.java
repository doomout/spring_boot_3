package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 이 클래스가 Spring MVC의 Controller임을 나타냅니다.
public class MemberController {
    @Autowired // 스프링이 자동으로 MemberRepository 객체를 주입해줍니다.
    MemberRepository memberRepository;

    @GetMapping("/signup") // "/signup" URL로 GET 요청이 오면 이 메서드가 실행됩니다.
    public String signUpPage() {
        // 회원가입 페이지로 이동하기 위한 뷰 이름을 반환합니다.
        return "members/new";  // "members/new"는 members 폴더 안에 있는 new.html 파일을 가리킵니다.
    }

    @PostMapping("/join") // "/join" URL로 POST 요청이 오면 이 메서드가 실행됩니다.
    public String join(MemberForm memberForm) {
        System.out.println(memberForm.toString());

        // MemberForm 객체를 Member 엔티티로 변환합니다.
        Member member = memberForm.toEntity();
        System.out.println(member.toString());

        // Member 엔티티를 데이터베이스에 저장하고, 저장된 엔티티를 반환받습니다.
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }
}
