package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());

        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }
    @GetMapping("/articles/{id}") //데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id); //확인용
        //1. id를 조회해 데이터 가져오기(데이터가 있으면 값을, 없으면 null 저장)
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //1-1.댓글 조회해 데이터 가져오기
        List<CommentDto> commentDtos = commentService.comments(id);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        //2-1.댓글 목록 모델에 등록
        model.addAttribute("commentDtos",commentDtos);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model) {
        //1. 모든 데이터 가져오기
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //2. 가져온 Aritcle 묶음을 모델에 등록하기
        model.addAttribute("articleList", articleEntityList);
        //3. 사용자에게 보여줄 뷰 페이지 설정하기
        return "articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) { //id를 매개변수로 받아오기
        //1.수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null); //DB에서 수정할 데이터 가져오기
        //2.모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        //3.뷰 페이지 설정하기
        return "articles/edit";
    }
    @PostMapping("/articles/update")
    public String update(ArticleForm form) { //매개변수로 DTO 받아오기
        log.info(form.toString());
        //1.DTO를 엔티티로 변환하기
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());
        //2-1.DB에서 기존 데이터 가져오기
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        //2-2.기존 데이터 값 갱신하기
        if(target != null) {
            articleRepository.save(articleEntity);
        }
        //3.수정 결과 페이지로 리다이렉트 하기
        return "redirect:/articles/" + articleEntity.getId();
    }
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) { //id를 매개변수로 가져오기, 리다이랙트 페이지에서 사용할 데이터
        log.info("삭제 요청 들어왔음!!");
        //1.삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        //2.대상 엔티티 삭제하기
        if(target != null) { //삭제할 대상 있는지 확인
            articleRepository.delete(target); //delete() 메서드로 삭제
            rttr.addFlashAttribute("msg", "삭제 성공!"); 
        }
        //3.목록 페이지로 리다이렉트하기
        return "redirect:/articles";
    }
}
