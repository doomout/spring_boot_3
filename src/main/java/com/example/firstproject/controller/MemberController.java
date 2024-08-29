package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 이 클래스가 Spring MVC의 Controller임을 나타냅니다.
@Slf4j //로깅 기능
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
        log.info(memberForm.toString());
        // MemberForm 객체를 Member 엔티티로 변환합니다.
        Member member = memberForm.toEntity();
        log.info(member.toString());
        // Member 엔티티를 데이터베이스에 저장하고, 저장된 엔티티를 반환받습니다.
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "";
    }
    //특정 회원 조회
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }
    //전체 회원 조회
    @GetMapping("/members")
    public String index(Model model) {
        Iterable<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members/index";
    }
}
