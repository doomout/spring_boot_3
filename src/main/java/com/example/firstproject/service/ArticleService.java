package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스 객체 생성
@Slf4j //log 사용
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository; //게시글 리파지터리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        //1.dto -> entity로 변환
        Article article = dto.toEntity();
        //2. id가 존재하면 이미 있는 데이터이므로 새로운 데이터를 생성하지 않음
        if(article.getId() != null && articleRepository.existsById(article.getId())) {
            return null;
        }
        //3.정상적이라면 article 를 DB에 저장
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        //1.DTO -> 엔티티 변환하기
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        //2.타딧 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        //3.잘못된 요청 처리하기
        if(target == null || id != article.getId()) {
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null; //응답은 컨트롤러가 하므로 여기서는 null 반환
        }
        //4.업데이트 및 정상 응답(200)하기
        target.patch(article); //기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(target); //수정 내용 DB에 최종 저장
        return updated; //응답은 컨트롤러가 하므로 수정 데이터만 반환
    }
}
