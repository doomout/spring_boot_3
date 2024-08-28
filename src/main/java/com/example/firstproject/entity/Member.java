package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // 이 클래스가 JPA 엔티티임을 나타냅니다.
public class Member {
    @Id // 이 필드가 엔티티의 기본 키임을 나타냅니다.
    @GeneratedValue // 기본 키 값을 자동으로 생성해줍니다
    Long id;

    @Column // 이 필드가 데이터베이스 테이블의 열과 매핑됨을 나타냅니다.
    String email;

    @Column // 이 필드가 데이터베이스 테이블의 열과 매핑됨을 나타냅니다.
    String password;

    public Member(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
