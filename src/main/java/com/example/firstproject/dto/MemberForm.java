package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import com.example.firstproject.entity.Member;

@AllArgsConstructor //생성자 단축
@ToString //toString 단축
public class MemberForm {
    // 사용자의 이메일과 비밀번호를 저장하는 필드
    private String email;
    private String password;

    // MemberForm 객체를 Member 엔티티로 변환하는 메서드
    public Member toEntity() {
        return new Member(null, email, password);
    }
}
