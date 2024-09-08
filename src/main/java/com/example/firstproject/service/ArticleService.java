package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //서비스 객체 생성
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
}
