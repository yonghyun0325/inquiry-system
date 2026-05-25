# Inquiry System

Spring Boot 기반 문의 관리 시스템 백엔드 프로젝트입니다.

## 프로젝트 목표

단순 CRUD 시스템이 아닌,
AI 문의 응답 시스템으로 확장 가능한 구조를 목표로 개발하고 있습니다.

---

## 기술 스택

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle
- Lombok
- Postman

---

## 주요 기능

### Inquiry API

- 문의 등록
- 문의 조회
- 문의 수정
- 문의 삭제

---

## API 구조

| Method | URL | 설명 |
|---|---|---|
| POST | /inquiries | 문의 등록 |
| GET | /inquiries | 문의 전체 조회 |
| GET | /inquiries/{id} | 문의 단건 조회 |
| PUT | /inquiries/{id} | 문의 수정 |
| DELETE | /inquiries/{id} | 문의 삭제 |

---

## 현재 진행 상황

- Spring Boot 프로젝트 생성
- MySQL 연동 완료
- JPA 설정 완료
- Inquiry Entity 생성
- 문의 등록 API 구현 완료
- GitHub 연동 완료

---

## 향후 계획

- CRUD 완성
- Validation 적용
- Exception Handling 적용
- Auditing 적용
- 관리자 답변 기능
- AI 자동 응답 기능 연동
- AWS 배포

---

## 프로젝트 실행

```bash
./gradlew bootRun
```

---

## DB 설정

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inquiry_db
spring.datasource.username=root
spring.datasource.password=비밀번호
```
