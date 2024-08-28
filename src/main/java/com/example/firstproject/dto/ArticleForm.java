package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title; //제목을 받을 코드
    private String content;  //내용을 받을 코드

    /** @AllArgsConstructor 로 대체
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
     */

    /** @ToString 로 대체
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    */
    public Article toEntity() {
        return new Article(null, title, content);
    }
}
