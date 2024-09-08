package com.example.firstproject.api;

import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired //게시글 리파지터리 주입
    private ArticleService articleService;

    //GET(전체 읽기)
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

    //GET(id별 읽기)
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }
//    //POST(생성)
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto) { //@RequestBody:요청시 body에 실어 보내는 데이터를 메개변수로 받아올 수 있다.
//        Article article = dto.toEntity();
//        return articleRepository.save(article);
//    }
//    //PATCH(수정)
//    @PatchMapping("/api/articles/{id}")
//    //ResponseEntity<> 클라이언트 요청 오류를 반환하기 위해 사용
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
//        //1.DTO -> 엔티티 변환하기
//        Article article = dto.toEntity();
//        log.info("id: {}, article: {}", id, article.toString());
//        //2.타딧 조회하기
//        Article target = articleRepository.findById(id).orElse(null);
//        //3.잘못된 요청 처리하기
//        if(target == null || id != article.getId()) {
//            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //잘못된 응답
//        }
//        //4.업데이트 및 정상 응답(200)하기
//        target.patch(article); //기존 데이터에 새 데이터 붙이기
//        Article updated = articleRepository.save(target); //수정 내용 DB에 최종 저장
//        return ResponseEntity.status(HttpStatus.OK).body(updated); //정상 응답
//    }
//    //DELETE(삭제)
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id) {
//        //1.대상 찾기
//        Article target = articleRepository.findById(id).orElse(null);
//        //2.잘못된 요청 처리하기
//        if(target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        //3.대상 삭제하기
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
