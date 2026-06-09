# 🚀 AI Inquiry Management System

> Spring Boot 기반 문의 관리 및 사용자 인증 시스템

사용자의 문의를 효율적으로 관리하고, 관리자 기능을 통해 문의 처리 현황을 모니터링할 수 있는 백엔드 플랫폼입니다.

단순 CRUD 구현을 넘어 JWT 기반 인증(Authentication), 권한 인가(Authorization), Refresh Token, 관리자(Admin) 기능, 통계 대시보드까지 포함한 실무형 백엔드 시스템을 목표로 개발하였습니다.

---

# 🎯 프로젝트 목표

본 프로젝트는 실제 서비스 환경에서 사용되는 백엔드 아키텍처를 학습하고 구현하는 것을 목표로 개발하였습니다.

주요 학습 내용은 다음과 같습니다.

* Spring Boot 기반 REST API 설계
* Spring Security 기반 인증/인가 구현
* JWT 및 Refresh Token 인증 구조 구현
* JPA 기반 데이터 관리
* 관리자(Admin) 기능 구현
* 통계 대시보드 구현
* Swagger 기반 API 문서화

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

## Database

* MySQL

## Documentation

* Swagger (OpenAPI)

## Build Tool

* Gradle

## Version Control

* Git
* GitHub

---

# ✨ 주요 기능

## 👤 사용자 기능

* 회원가입
* 로그인
* 내 정보 조회
* 비밀번호 BCrypt 암호화

---

## 🔐 인증 및 보안

* JWT Access Token 발급
* JWT 인증 필터 구현
* Role 기반 권한 관리
* Refresh Token 발급
* Refresh Token DB 저장
* Access Token 재발급 API
* 로그아웃 API

---

## 📋 문의 관리

* 문의 등록
* 문의 전체 조회
* 문의 상세 조회
* 문의 수정
* 문의 삭제

---

## 🔎 검색 및 페이징

* 제목 검색
* 카테고리 검색
* 상태 검색
* 복합 검색
* Pageable 기반 페이징
* 검색 + 페이징

---

## 🛡 관리자 기능

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

# 🏗 프로젝트 구조

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

로그아웃
 ↓
Refresh Token 삭제
```

---

# 🌐 주요 API

## Inquiry API

* POST /inquiries
* GET /inquiries
* GET /inquiries/{id}
* PUT /inquiries/{id}
* DELETE /inquiries/{id}
* GET /inquiries/search
* GET /inquiries/page
* GET /inquiries/search/page

## User API

* POST /users/signup
* POST /users/login
* GET /users/me
* POST /users/refresh
* POST /users/logout

## Admin API

* GET /admin/test
* GET /admin/users
* PATCH /admin/users/{id}/role
* PATCH /admin/users/{id}/status
* GET /admin/inquiries
* GET /admin/inquiries/{id}
* PATCH /admin/inquiries/{id}/status
* PATCH /admin/inquiries/{id}/answer
* GET /admin/dashboard

---

# 📈 구현 완료 기능

## Core

* [x] CRUD 구현
* [x] DTO 분리
* [x] Validation 적용
* [x] Global Exception Handling 적용
* [x] JPA Auditing 적용
* [x] Swagger 적용

## Security

* [x] Spring Security
* [x] JWT 인증
* [x] Refresh Token
* [x] Access Token 재발급
* [x] 로그아웃

## Search

* [x] 검색
* [x] 복합 검색
* [x] 페이징

## Admin

* [x] 회원 관리
* [x] 문의 관리
* [x] 관리자 대시보드

---

# 🚀 향후 확장 계획

* 일정 관리(Schedule Management)
* OpenAI API 연동
* AI 문의 자동 답변
* AI 문의 자동 분류
* 이메일 알림 기능
* 통계 차트 기능

---

# 🎯 프로젝트 회고

본 프로젝트를 통해 Spring Boot 기반 REST API 설계부터 Spring Security, JWT 인증/인가, Refresh Token, 관리자 기능 구현까지 경험할 수 있었습니다.

특히 단순 CRUD를 넘어 실제 서비스에서 사용되는 인증 구조와 관리자 기능을 직접 설계하고 구현하며 백엔드 개발 역량을 향상시킬 수 있었습니다.

향후 OpenAI API와 일정 관리 기능을 추가하여 AI 기반 문의 관리 플랫폼으로 확장할 계획입니다.
