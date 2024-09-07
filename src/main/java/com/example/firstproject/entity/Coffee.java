package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Coffee {
    @Id //이 필드가 엔티티의 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키의 값을 자동으로 생성
    Long id;

    @Column
    String name;

    @Column
    String price;

    public void patch(Coffee coffee) {
        if(coffee.name != null)
            this.name = coffee.name;
        if(coffee.price != null)
            this.price = coffee.price;
    }
}
