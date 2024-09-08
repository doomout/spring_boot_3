package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired //리파지터리 주입
    private CoffeeRepository coffeeRepository;

    //GET(전체 조회)
    @GetMapping("/api/coffees")
    public Iterable<Coffee> index() {
        return coffeeRepository.findAll();
    }
    //GET(id별 조회)
    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id) { //id를 매개 변수로 받아오기
        Coffee coffee = coffeeRepository.findById(id).orElse(null);
        //데이터가 있으면 ? OK 신호 : BAD_REQUEST 신호
        return (coffee != null) ?
                ResponseEntity.status(HttpStatus.OK).body(coffee) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    //POST(생성)
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto coffeeDto) {
        Coffee coffee = coffeeDto.toEntity();
        //null 처리 추가
        if(coffee.getId() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Coffee created = coffeeRepository.save(coffee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    //PATCH(수정)
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto coffeeDto) {
        //1.DTO -> Entity 변환
        Coffee coffee = coffeeDto.toEntity();
        log.info("id: {}, coffee: {}", id, coffee.toString());
        //2.타깃 조회하기
        Coffee target = coffeeRepository.findById(id).orElse(null);
        //3.잘못된 요청 처리하기
        if(target == null || id != coffee.getId()) {
            log.info("잘못된 요청! id: {}, coffee: {}", id, coffee.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //4.업데이트 하기
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        //5.정상 응답(200)하기
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    //DELETE(삭제)
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        //1.삭제 대상 찾기
        Coffee target = coffeeRepository.findById(id).orElse(null);
        //2.대상이 없으면 BAD_REQUEST 처리 
        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //3.대상이 있으면 삭제 처리
        coffeeRepository.delete(target);
        //4.OK 처리
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
