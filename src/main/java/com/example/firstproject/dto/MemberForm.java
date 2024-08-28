package com.example.firstproject.dto;

import com.example.firstproject.entity.Member;

public class MemberForm {
    // 사용자의 이메일과 비밀번호를 저장하는 필드
    private String email;
    private String password;

    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // 객체를 문자열로 표현할 때 사용됩니다. (주로 디버깅 목적)
    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // MemberForm 객체를 Member 엔티티로 변환하는 메서드
    public Member toEntity() {
        return new Member(null, email, password);
    }
}
