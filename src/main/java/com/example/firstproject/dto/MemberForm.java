package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import com.example.firstproject.entity.Member;

@AllArgsConstructor //생성자 단축
@ToString //toString 단축
public class MemberForm {
    private Long id;
    private String email;
    private String password;

    // MemberForm 객체를 Member 엔티티로 변환하는 메서드
    public Member toEntity() {
        return new Member(id, email, password);
    }
}
