# 🚀 Inquiry System

> Spring Boot + JPA 기반 문의 관리 및 사용자 인증 시스템 백엔드 프로젝트

단순 CRUD 구현이 아닌,  
실무형 REST API 구조와 사용자 인증 흐름을 포함한 백엔드 아키텍처 학습을 목표로 개발 중입니다.

---

# 🛠 Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- Validation
- JWT
- Swagger(OpenAPI)

## Database
- MySQL

## Build Tool
- Gradle

## API Test
- Postman
- Swagger UI

## Version Control
- Git
- GitHub

---

# 📂 Project Structure

```plaintext
common
 ┣ 공통 API 응답 구조

controller
 ┣ Inquiry API 요청 처리

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

security
 ┣ Spring Security 설정
 ┣ JWT 생성 로직

user
 ┣ 사용자 Entity / Repository / Service / Controller
 ┣ 회원가입 요청 DTO
 ┣ 로그인 요청 DTO
 ┣ 로그인 응답 DTO
 ┣ 사용자 응답 DTO
```

---

# ✨ Features

## ✅ Inquiry CRUD API

문의 관리 기능을 REST API 기반으로 구현했습니다.

- 문의 등록
- 문의 전체 조회
- 문의 단건 조회
- 문의 수정
- 문의 삭제

---

## ✅ Search API

제목 기반 및 조건 기반 문의 검색 기능을 구현했습니다.

### Search Example

```http
GET /inquiries/search?title=배터리
```

### Dynamic Search Example

```http
GET /inquiries/search?title=배터리&category=BATTERY&status=REQUESTED
```

---

## ✅ Pagination API

페이지 기반 조회 기능을 구현했습니다.

### Pagination Example

```http
GET /inquiries/page?page=0&size=5
```

### Search + Pagination Example

```http
GET /inquiries/search/page?category=BATTERY&page=0&size=3
```

---

## ✅ User Management API

사용자 회원가입 및 로그인 기능을 구현했습니다.

### Signup

- 이메일 중복 체크
- 비밀번호 BCrypt 암호화
- 기본 권한 설정
- 기본 상태 설정

```plaintext
ROLE_USER
ACTIVE
```

### Login

- 이메일 기반 사용자 조회
- 비밀번호 검증
- JWT Access Token 발급

---

## ✅ JWT Authentication

로그인 성공 시 JWT Access Token을 발급하도록 구현했습니다.

### Login Response Example

```json
{
  "success": true,
  "message": "로그인 성공",
  "data": {
    "accessToken": "eyJhbGciOiJIUzI1NiJ9..."
  }
}
```

### JWT Info

```plaintext
Subject    : 사용자 이메일
Algorithm  : HS256
Expiration : 1시간
```

---

## ✅ Validation

사용자 요청 데이터 검증 기능을 적용했습니다.

```java
@NotBlank
@Email
@Valid
```

잘못된 요청을 차단하고 커스텀 메시지를 반환하도록 구현했습니다.

---

## ✅ Global Exception Handling

```java
@RestControllerAdvice
```

기반 전역 예외 처리를 적용했습니다.

### Error Response Example

```json
{
  "success": false,
  "message": "이메일 형식이 아닙니다.",
  "data": null
}
```

---

## ✅ Common API Response

모든 API 응답 구조를 통일했습니다.

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

## ✅ JPA Auditing

생성일과 수정일을 자동으로 관리하도록 적용했습니다.

```java
@CreatedDate
@LastModifiedDate
```

---

## ✅ Swagger API Documentation

Swagger(OpenAPI)를 적용하여 API 문서 자동화 및 브라우저 기반 테스트 환경을 구성했습니다.

### Swagger URL

```plaintext
http://localhost:8080/swagger-ui/index.html
```

---

# 📌 Entity Design

## Inquiry Entity

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

## User Entity

```plaintext
id
email
password
name
phone
role
status
createdAt
updatedAt
```

---

# 🌐 API Endpoints

## Inquiry API

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

## User API

| Method | URL | Description |
|---|---|---|
| POST | `/users/signup` | 회원가입 |
| POST | `/users/login` | 로그인 및 JWT 발급 |

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
- [x] 회원가입 기능 구현
- [x] 로그인 기능 구현
- [x] BCrypt 비밀번호 암호화 적용
- [x] JWT Access Token 발급
- [ ] JWT 인증 필터 구현
- [ ] 인증 / 권한 처리
- [ ] AI 문의 응답 기능

---

# 🔜 Next Step

- JWT 인증 필터 구현
- Authorization Header 기반 토큰 검증
- 인증 필요한 API 보호
- 사용자 권한 기반 접근 제어
- AI 문의 응답 기능 연동

---

# 🎯 Goal

단순 CRUD 프로젝트를 넘어,  
문의 관리 기능과 사용자 인증 흐름을 포함한 실무형 REST API 백엔드 구조를 학습하고 있습니다.

향후 JWT 인증 필터와 권한 처리를 추가하고,  
AI 문의 응답 기능을 연동하여 AI 기반 문의 관리 시스템으로 확장하는 것을 목표로 합니다.
