### 스프링 부트3 백엔드 공부
서적: 코딩 자율 학습 - 스프링 부트3 자바 백엔드 개발 입문  
IDE : IntelliJ IDEA 2024.2.0.2 (Community Edition)   
Java: openjdk version "17.0.12"   

### 추가 개발 도구  
Web: Spring Boot 3.2.9  
DB(현재 사용x): H2_console  
DB: PostgreSQL 16.4  
템플릿 엔진: Mustache  
DB관리 API: JPA  
뷰 템플릿: Bootstrap 5.0.2  
리팩토링 라이브러리: Lombok 1.18.34

### 1.게시판 본문
![1](https://github.com/user-attachments/assets/9579c814-9664-4c88-99f4-b9a288d21d96)

### 2.게시판 댓글
![2](https://github.com/user-attachments/assets/a4ff8f60-f428-46e1-8b3d-3bb9197ab8be)  

### 이슈 기록   
8080포트 사용 중인지 확인 명령어 : netstat -ano | findstr :8080  
이미 사용 중이라면  
application.properties 파일에 server.port=포트 번호    

h2 DB 사용 설정  
spring.h2.console.enabled=true  

더미 데이터 넣을 때(스프링 부트 2.5 이상에서 사용)  
resources/data.sql 에 insert 문을 넣으면 실행시마다 자동 생성  
application.properties 에서 추가   
spring.jpa.defer-datasource-initialization=true  
 
REST API 연습 사이트  
https://jsonplaceholder.typicode.com/

크롬 확장 프로그램   
https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ko&utm_source=ext_sidebar  

### PostgreSQL 설정  
--build.gradle  
runtimeOnly 'org.postgresql:postgresql'

--application.properties  
spring.datasource.url=jdbc:postgresql://localhost:5432/DB명  
spring.datasource.username=아이디  
spring.datasource.password=암호  

spring.jpa.hibernate.ddl-auto=update  
spring.datasource.initialization-mode=never  

