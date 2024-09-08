package com.example.firstproject.repository;

import com.example.firstproject.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

// Member 엔티티에 대해 CRUD 작업을 수행하는 리포지토리 인터페이스
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
