# 🚀 AI Inquiry Management System

> Spring Boot 기반 AI 문의 관리 플랫폼 백엔드 프로젝트

사용자 문의를 효율적으로 관리하기 위한 REST API 기반 백엔드 시스템입니다.

단순 CRUD 구현을 넘어 JWT 인증, Refresh Token, 관리자 기능, 검색/페이징, 대시보드 기능을 포함한 실무형 백엔드 아키텍처를 목표로 개발하였습니다.

향후 OpenAI 연동을 통해 문의 자동 분류 및 AI 답변 기능을 추가하여 AI 기반 고객 문의 관리 플랫폼으로 확장할 예정입니다.

---

# 🛠 Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* Validation
* JWT
* Swagger (OpenAPI)

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

# ✨ 주요 기능

## 문의 관리

* 문의 등록
* 문의 전체 조회
* 문의 상세 조회
* 문의 수정
* 문의 삭제

## 검색 및 페이징

* 제목 검색
* 카테고리 검색
* 상태 검색
* 복합 검색
* Pageable 기반 페이징
* 검색 + 페이징

## 사용자 기능

* 회원가입
* 로그인
* 내 정보 조회
* BCrypt 비밀번호 암호화

## 인증 및 보안

* Spring Security 적용
* JWT Access Token 발급
* JWT 인증 필터 구현
* Role 기반 권한 제어
* Refresh Token 발급
* Refresh Token DB 저장
* Access Token 재발급 API

## 관리자 기능

### 회원 관리

* 회원 목록 조회
* 사용자 권한 변경
* 사용자 상태 변경

### 문의 관리

* 문의 목록 조회
* 문의 상세 조회
* 문의 상태 변경
* 문의 답변 등록

### 관리자 대시보드

* 전체 회원 수 조회
* 활성 회원 수 조회
* 비활성 회원 수 조회
* 전체 문의 수 조회
* 처리 대기 문의 수 조회
* 처리 완료 문의 수 조회
* 오늘 접수 문의 수 조회
* 문의 처리율 조회

---

# 📌 프로젝트 구조

```plaintext
common
 ┣ 공통 응답 객체

controller
 ┣ InquiryController
 ┣ UserController
 ┣ AdminController

service
 ┣ InquiryService
 ┣ UserService

repository
 ┣ InquiryRepository
 ┣ UserRepository
 ┣ RefreshTokenRepository

entity
 ┣ Inquiry
 ┣ User
 ┣ RefreshToken

dto
 ┣ Request DTO
 ┣ Response DTO

security
 ┣ SecurityConfig
 ┣ JwtProvider
 ┣ JwtAuthenticationFilter

exception
 ┣ GlobalExceptionHandler
```

---

# 📌 데이터 모델

## Inquiry

```plaintext
id
category
title
content
customerName
customerEmail
status
answer
createdAt
updatedAt
```

## User

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

## RefreshToken

```plaintext
id
userId
token
expiredAt
```

---

# 🌐 주요 API

## Inquiry API

POST /inquiries

GET /inquiries

GET /inquiries/{id}

PUT /inquiries/{id}

DELETE /inquiries/{id}

GET /inquiries/search

GET /inquiries/page

GET /inquiries/search/page

---

## User API

POST /users/signup

POST /users/login

GET /users/me

POST /users/refresh

---

## Admin API

GET /admin/test

GET /admin/users

PATCH /admin/users/{id}/role

PATCH /admin/users/{id}/status

GET /admin/inquiries

GET /admin/inquiries/{id}

PATCH /admin/inquiries/{id}/status

PATCH /admin/inquiries/{id}/answer

GET /admin/dashboard

---

# 🔒 인증 구조

```plaintext
로그인
 ↓
Access Token 발급
 ↓
Refresh Token 발급
 ↓
Refresh Token DB 저장
 ↓
API 요청
 ↓
JWT 인증 필터 검증
 ↓
권한 확인
 ↓
API 접근

Access Token 만료
 ↓
Refresh Token 사용
 ↓
새 Access Token 발급
```

---

# 📈 현재 진행 상황

## Core

* [x] CRUD
* [x] DTO 분리
* [x] Validation
* [x] Global Exception Handling
* [x] JPA Auditing
* [x] Swagger

## Security

* [x] Spring Security
* [x] JWT 인증
* [x] JWT 권한 관리
* [x] Refresh Token
* [x] Access Token 재발급

## Admin

* [x] 회원 관리
* [x] 문의 관리
* [x] 관리자 대시보드

## Search

* [x] 검색
* [x] 복합 검색
* [x] 페이징

---

# 🔜 향후 개발 계획

* 일정 관리(Schedule Management)
* 로그아웃 API
* OpenAI API 연동
* AI 문의 자동 답변
* AI 문의 자동 분류
* 통계 차트 기능
* 이메일 알림 기능

---

# 🎯 프로젝트 목표

단순 CRUD 프로젝트를 넘어 실제 서비스에서 사용되는 인증/인가 구조와 관리자 기능을 경험하고 구현하는 것을 목표로 하였습니다.

또한 OpenAI 기반 AI 문의 처리 기능을 추가하여 AI 기반 고객 문의 관리 플랫폼으로 확장할 예정입니다.
