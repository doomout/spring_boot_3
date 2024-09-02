교제: 코딩 자율 학습 - 스프링 부트3 자바 백엔드 개발 입문  
IDE : IntelliJ IDEA 2024.2.0.2 (Community Edition)   
Java: openjdk version "17.0.12"   
추가 개발 도구  
Web: Spring Boot 3.2.9  
H2 Database: 자료를 저장하기 위한 데이터 베이스  
Mustache: 화면을 만들기 위한 도구  
Spring Data JPA: 데이터베이스를 쉽게 다룰 수 있는 도구  
뷰 템플릿 : 부트스트랩 5.0.2  
리팩터리 : 롬복 1.18.34

--이슈 기록--   
8080포트 사용 중인지 확인 명령어 : netstat -ano | findstr :8080  
이미 사용 중이라면  
application.properties 파일에 server.port=포트 번호    

h2 DB 사용 설정  
spring.h2.console.enabled=true  

더미 데이터 넣을 때(스프링 부트 2.5 이상에서 사용)  
spring.jpa.defer-datasource-initialization=true  
