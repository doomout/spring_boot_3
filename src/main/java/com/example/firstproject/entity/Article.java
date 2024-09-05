package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor //기본 생성자 추가
@ToString
@Entity //엔티티 선언
@Getter //외부에서 객체의 데이터를 읽을 때 사용
public class Article {
    @Id //엔티티의 대표값 지정

    @GeneratedValue(strategy= GenerationType.IDENTITY) //자동 생성기능 추가(DB가 id 자동 생성)
    private Long id;

    @Column //title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;

    @Column //content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    //수정할 내용이 있는 경우에만 동작
    public void patch(Article article) {
        //갱신 값이 있으면 갱신
        if(article.title != null)
            this.title = article.title;
        if(article.content != null)
            this.content = article.content;
    }
}
