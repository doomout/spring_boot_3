package com.example.firstproject.api;

import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired //리파지터리 주입
    private CoffeeRepository coffeeRepository;

    //GET(읽기)
    @GetMapping("/api/coffees")
    public Iterable<Coffee> index() {
        return coffeeRepository.findAll();
    }
    //POST(생성)
    //PATCH(수정)
    //DELETE(삭제)
}
