package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired //리파지터리 주입
    private CoffeeService coffeeService;

    //GET(전체 조회)
    @GetMapping("/api/coffees")
    public Iterable<Coffee> index() {
        return coffeeService.index();
    }

    //GET(id별 조회)
    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id) {
        Coffee created = coffeeService.show(id);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //POST(생성)
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto coffeeDto) {
        Coffee created = coffeeService.create(coffeeDto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //PATCH(수정)
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto coffeeDto) {
        Coffee updated = coffeeService.update(id, coffeeDto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//    //DELETE(삭제)
//    @DeleteMapping("/api/coffees/{id}")
//    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
//        //1.대상 찾기
//        Coffee target = coffeeRepository.findById(id).orElse(null);
//        //2.잘못된 요청 처리하기
//        if(target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        //3.대상 삭제하기
//        coffeeRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
