package com.example.firstproject.service;

import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository; //댓글 리파지터리 객체 주입
    @Autowired
    private ArticleRepository articleRepository; //게시글 리파지터리 객체 주입
}
