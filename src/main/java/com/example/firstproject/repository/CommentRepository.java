package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //특정 게시글의 모든 댓글 조회(@Query 사용 버전)
    @Query(value="SELECT * FROM comment WHERE article_id= :articleId", nativeQuery = true) //value 속성에 실행하려는 쿼리 작성
    List<Comment> findByArticleId(Long articleId);

    //특정 닉네임의 모든 댓글 조회(orm.xml 파일 사용 버전)
    //orm.xml 기본 경로(resources>META-INF>orm.xml)
    List<Comment> findByNickname(String nickname);
}
