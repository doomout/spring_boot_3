package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Coffee {
    @Id //이 필드가 엔티티의 기본키
    @GeneratedValue //기본키의 값을 자동으로 생성
    Long id;

    @Column
    String name;

    @Column
    String price;
}
