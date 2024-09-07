package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CoffeeDto {
    private Long id; 
    private String name; //커피 이름
    private String price; //가격

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
