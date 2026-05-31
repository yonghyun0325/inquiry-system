# 🚀 Inquiry System

> Spring Boot + JPA 기반 문의 관리 시스템 백엔드 프로젝트

단순 CRUD 구현이 아닌,  
실무형 REST API 구조와 유지보수 가능한 백엔드 아키텍처 학습을 목표로 개발 중입니다.

---

# 🛠 Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate

## Database
- MySQL

## Build Tool
- Gradle

## API Test
- Postman
- Swagger

## Version Control
- Git
- GitHub

---

# 📂 Project Structure

```plaintext
controller
 ┣ API 요청 처리

service
 ┣ 비즈니스 로직 처리

repository
 ┣ JPA 기반 DB 접근

entity
 ┣ DB 테이블 매핑

dto
 ┣ Request / Response 데이터 분리

exception
 ┣ Global Exception Handling

common
 ┣ 공통 API 응답 구조
```

---

# ✨ Features

## ✅ Inquiry CRUD API

- 문의 등록(Create)
- 문의 전체 조회(Read)
- 문의 단건 조회(Read)
- 문의 수정(Update)
- 문의 삭제(Delete)

---

# ✅ Search API

제목 기반 및 조건 기반 문의 검색 기능 구현

### Search Example

```http
GET /inquiries/search?title=배터리
```

### Dynamic Search Example

```http
GET /inquiries/search?title=배터리&category=BATTERY&status=REQUESTED
```

### JPA Query Method

```java
findByTitleContaining(String title)
```

---

# ✅ Pagination API

페이지 기반 조회 기능 구현

### Pagination Example

```http
GET /inquiries/page?page=0&size=5
```

### Search + Pagination Example

```http
GET /inquiries/search/page?category=BATTERY&page=0&size=3
```

### Pageable Default

```java
@PageableDefault(
    size = 5,
    sort = "id",
    direction = Sort.Direction.DESC
)
```

---

# ✅ Validation

사용자 요청 데이터 검증 기능 적용

```java
@NotBlank
@Email
@Valid
```

잘못된 요청 차단 및 커스텀 메시지 반환 구현

---

# ✅ Global Exception Handling

```java
@RestControllerAdvice
```

기반 전역 예외 처리 적용

### Error Response Example

```json
{
  "success": false,
  "message": "이메일 형식이 아닙니다.",
  "data": null
}
```

---

# ✅ Common API Response

모든 API 응답 구조 통일

### Success Response Example

```json
{
  "success": true,
  "message": "문의 등록 성공",
  "data": {
    ...
  }
}
```

---

# ✅ JPA Auditing

생성 및 수정 시간 자동 관리 적용

```java
@CreatedDate
@LastModifiedDate
```

---

# ✅ Swagger API Documentation

Swagger(OpenAPI)를 적용하여  
API 문서 자동화 및 브라우저 기반 테스트 환경 구성

### Swagger URL

```plaintext
http://localhost:8080/swagger-ui/index.html
```

### Swagger Features

- API 그룹화
- API 설명(summary / description)
- 브라우저 기반 API 테스트
- Request / Response 자동 문서화

---

# 📌 Inquiry Entity

```plaintext
id
category
title
content
customerName
customerEmail
status
createdAt
updatedAt
```

---

# 🌐 API Endpoints

| Method | URL | Description |
|---|---|---|
| POST | `/inquiries` | 문의 등록 |
| GET | `/inquiries` | 문의 전체 조회 |
| GET | `/inquiries/{id}` | 문의 단건 조회 |
| PUT | `/inquiries/{id}` | 문의 수정 |
| DELETE | `/inquiries/{id}` | 문의 삭제 |
| GET | `/inquiries/search` | 문의 검색 |
| GET | `/inquiries/page` | 문의 페이징 조회 |
| GET | `/inquiries/search/page` | 검색 + 페이징 조회 |

---

# 📈 Current Progress

- [x] Spring Boot 프로젝트 생성
- [x] MySQL 연동
- [x] JPA CRUD 구현
- [x] DTO 분리
- [x] Validation 적용
- [x] Global Exception Handling 적용
- [x] API 응답 구조 통일
- [x] JPA Auditing 적용
- [x] Swagger 문서화 적용
- [x] 제목 검색 기능 구현
- [x] 복합 검색 기능 구현
- [x] Pageable 기반 페이징 구현
- [x] 검색 + 페이징 기능 구현
- [x] Swagger API 설명 적용
- [ ] JWT 로그인
- [ ] 회원가입 기능
- [ ] 인증 / 권한 처리
- [ ] AI 문의 응답 기능

---

# 🎯 Goal

단순 CRUD 프로젝트를 넘어,  
실무형 REST API 백엔드 구조와 유지보수 가능한 Spring Boot 아키텍처 학습을 목표로 개발 중입니다.
