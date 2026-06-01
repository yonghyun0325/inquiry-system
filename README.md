# 🚀 Inquiry System

> Spring Boot + JPA 기반 문의 관리 및 사용자 인증 시스템 백엔드 프로젝트

단순 CRUD 구현이 아닌,
실무형 REST API 구조와 사용자 인증(Authentication) 및 권한 인가(Authorization) 흐름을 포함한 백엔드 아키텍처 학습을 목표로 개발 중입니다.

---

# 🛠 Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* Validation
* JWT
* Swagger(OpenAPI)

## Database

* MySQL

## Build Tool

* Gradle

## API Test

* Postman
* Swagger UI

## Version Control

* Git
* GitHub

---

# 📂 Project Structure

```plaintext
common
 ┣ 공통 API 응답 구조

controller
 ┣ Inquiry API 요청 처리
 ┣ Admin API 요청 처리

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
 ┣ SecurityConfig
 ┣ JwtProvider
 ┣ JwtAuthenticationFilter

user
 ┣ 사용자 Entity / Repository / Service / Controller
 ┣ 회원가입 요청 DTO
 ┣ 로그인 요청 DTO
 ┣ 로그인 응답 DTO
 ┣ 사용자 응답 DTO
 ┣ 내 정보 조회 DTO
```

---

# ✨ Features

## ✅ Inquiry CRUD API

문의 관리 기능을 REST API 기반으로 구현했습니다.

* 문의 등록
* 문의 전체 조회
* 문의 단건 조회
* 문의 수정
* 문의 삭제

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

* 이메일 중복 체크
* BCrypt 비밀번호 암호화
* 기본 권한 설정
* 기본 상태 설정

```plaintext
ROLE_USER
ACTIVE
```

### Login

* 이메일 기반 사용자 조회
* 비밀번호 검증
* JWT Access Token 발급

---

## ✅ JWT Authentication

로그인 성공 시 JWT Access Token을 발급하고, 보호된 API 접근 시 JWT 기반 인증을 수행하도록 구현했습니다.

### Login Response Example

```json
{
  "success": true,
  "message": "로그인 성공",
  "data": {
    "accessToken": "eyJhbGciOiJIUzUxMiJ9..."
  }
}
```

### JWT Info

```plaintext
Subject    : 사용자 이메일
Algorithm  : HS512
Expiration : 1시간
```

### JWT Authentication Features

* JWT Access Token 발급
* JWT 토큰 검증
* JwtAuthenticationFilter 구현
* Authorization Header 인증 처리
* SecurityContext 인증 등록

### Authentication Example

```http
GET /inquiries
Authorization: Bearer {JWT_TOKEN}
```

JWT 토큰 없이 접근 시

```plaintext
403 Forbidden
```

JWT 토큰 포함 시

```plaintext
200 OK
```

---

## ✅ Role-Based Authorization

JWT 기반 권한(Role) 제어 기능을 구현했습니다.

### Supported Roles

```plaintext
ROLE_USER
ROLE_ADMIN
```

### Authorization Flow

```plaintext
로그인
↓
JWT 발급
↓
Role 저장
↓
JWT 검증
↓
SecurityContext 등록
↓
권한 검사
```

### Admin API Example

```http
GET /admin/test
```

### Authorization Result

```plaintext
ROLE_USER  → 403 Forbidden
ROLE_ADMIN → 200 OK
```

---

## ✅ User Profile API

현재 로그인한 사용자 정보를 조회할 수 있습니다.

### Example

```http
GET /users/me
Authorization: Bearer {JWT_TOKEN}
```

### Response

```json
{
  "success": true,
  "message": "내 정보 조회 성공",
  "data": {
    "id": 2,
    "email": "security@test.com",
    "name": "보안테스트",
    "role": "ROLE_ADMIN"
  }
}
```

---

## ✅ Validation

사용자 요청 데이터 검증 기능을 적용했습니다.

```java
@NotBlank
@Email
@Valid
```

---

## ✅ Global Exception Handling

```java
@RestControllerAdvice
```

기반 전역 예외 처리를 적용했습니다.

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

| Method | URL                      | Description |
| ------ | ------------------------ | ----------- |
| POST   | `/inquiries`             | 문의 등록       |
| GET    | `/inquiries`             | 문의 전체 조회    |
| GET    | `/inquiries/{id}`        | 문의 단건 조회    |
| PUT    | `/inquiries/{id}`        | 문의 수정       |
| DELETE | `/inquiries/{id}`        | 문의 삭제       |
| GET    | `/inquiries/search`      | 문의 검색       |
| GET    | `/inquiries/page`        | 문의 페이징 조회   |
| GET    | `/inquiries/search/page` | 검색 + 페이징 조회 |

## User API

| Method | URL             | Description   |
| ------ | --------------- | ------------- |
| POST   | `/users/signup` | 회원가입          |
| POST   | `/users/login`  | 로그인 및 JWT 발급  |
| GET    | `/users/me`     | 현재 로그인 사용자 조회 |

## Admin API

| Method | URL           | Description |
| ------ | ------------- | ----------- |
| GET    | `/admin/test` | 관리자 권한 테스트  |
|        |               |             |
# 📈 Current Progress

## Core

* [x] Spring Boot 프로젝트 생성
* [x] MySQL 연동
* [x] JPA CRUD 구현
* [x] DTO 분리
* [x] Validation 적용
* [x] Global Exception Handling 적용
* [x] API 응답 구조 통일
* [x] JPA Auditing 적용
* [x] Swagger 문서화 적용

---

## Inquiry

* [x] 문의 등록

* [x] 문의 전체 조회

* [x] 문의 단건 조회

* [x] 문의 수정

* [x] 문의 삭제

* [x] 제목 검색 기능 구현

* [x] 복합 검색 기능 구현

* [x] Pageable 기반 페이징 구현

* [x] 검색 + 페이징 기능 구현

---

## User

* [x] 회원가입 기능 구현
* [x] 로그인 기능 구현
* [x] BCrypt 비밀번호 암호화 적용

---

## Security

### Authentication

* [x] Spring Security 적용
* [x] JWT Access Token 발급
* [x] JWT 토큰 검증
* [x] JwtAuthenticationFilter 구현
* [x] Authorization Header 인증 처리
* [x] SecurityContext 인증 등록

### User Information

* [x] 현재 로그인 사용자 조회 API (/users/me)

### Authorization

* [x] JWT Role Claim 적용
* [x] ROLE_USER 구현
* [x] ROLE_ADMIN 구현
* [x] Spring Security 권한 등록
* [x] Role 기반 접근 제어
* [x] Admin API 보호
* [x] 관리자 권한 검증 완료

---

## Documentation

* [x] Swagger API 설명 적용
* [x] README 문서화

---

## In Progress

* [ ] Refresh Token 적용
* [ ] 관리자 회원 관리 기능
* [ ] 관리자 문의 관리 기능
* [ ] AI 문의 응답 기능
* [ ] AI 문의 자동 분류 기능

---

# 🔜 Next Step

## Admin Features

* 관리자 회원 목록 조회 API
* 사용자 권한(Role) 변경 API
* 사용자 상태(Status) 변경 API
* 관리자 문의 목록 조회 API
* 관리자 문의 상태 변경 API

## Security

* Refresh Token 구현
* Access Token 재발급 API 구현
* 로그아웃 처리

## AI

* OpenAI API 연동
* AI 문의 자동 답변
* AI 문의 카테고리 분류
* AI 답변 저장 기능

---

# 🎯 Goal

단순 CRUD 프로젝트를 넘어,

* JWT 기반 인증(Authentication)
* Role 기반 권한 인가(Authorization)
* 관리자(Admin) 기능
* AI 문의 자동 응답

을 포함한 실무형 백엔드 시스템 구축을 목표로 합니다.

현재는 Spring Security와 JWT 기반 인증/인가 구조를 구현하였으며,

향후 Refresh Token,
관리자 기능,
AI 문의 자동 분류 및 답변 기능을 추가하여

**AI 기반 문의 관리 플랫폼(AI Inquiry Management Platform)** 으로 확장하는 것을 목표로 합니다.

---

# 🚀 Project Status

```plaintext
CRUD                  ✅ 완료
검색                  ✅ 완료
페이징                ✅ 완료

회원가입              ✅ 완료
로그인                ✅ 완료
BCrypt                ✅ 완료

JWT 발급              ✅ 완료
JWT 검증              ✅ 완료
JWT Filter            ✅ 완료

/users/me            ✅ 완료

ROLE_USER            ✅ 완료
ROLE_ADMIN           ✅ 완료

관리자 접근 제어       ✅ 완료

Refresh Token        ⏳ 예정
관리자 기능           ⏳ 진행 예정
AI 문의 응답          ⏳ 진행 예정
```
