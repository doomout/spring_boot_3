--기존 데이터
INSERT INTO article(title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');
INSERT INTO article(title, content) VALUES('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES('당신의 취미는?', '댓글 고고고');
--4번 게시글에 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(4, '김재벌', '어벤져스 인피니티 워');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '조재벌', '레미제라블');
INSERT INTO comment(article_id, nickname, body) VALUES(4, '이재벌', '라라랜드');
--5번 게시글에 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(5, '김재벌', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '조재벌', '라면');
INSERT INTO comment(article_id, nickname, body) VALUES(5, '이재벌', '돈가스');
--6번 게시글에 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES(6, '김재벌', '헬스');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '조재벌', '노래');
INSERT INTO comment(article_id, nickname, body) VALUES(6, '이재벌', '독서');

--Self_Check 데이터
INSERT INTO coffee(name, price) VALUES('아메리카노', '5000');
INSERT INTO coffee(name, price) VALUES('라떼', '6000');
INSERT INTO coffee(name, price) VALUES('콜드브루', '6500');
