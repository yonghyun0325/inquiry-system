# 🚀 Inquiry System

Spring Boot와 JPA를 기반으로 개발한 문의 관리 시스템입니다.

단순 CRUD 프로젝트가 아닌 실무 환경에서 자주 사용되는 구조를 학습하기 위해 개발 중이며, 사용자 인증과 JWT 기반 보안 기능을 포함하고 있습니다.

---

# 🎯 프로젝트 목표

* 문의 관리 시스템 구현
* REST API 설계 및 개발
* Spring Data JPA 활용
* 예외 처리 표준화
* Swagger API 문서화
* JWT 기반 인증 시스템 구현
* Role 기반 권한 관리 구현
* AI 기반 문의 응답 시스템 확장

---

# 🛠 Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* JWT (JJWT)
* Hibernate Validator

### Database

* MySQL

### Documentation

* Swagger (OpenAPI)

### Build Tool

* Gradle

### Version Control

* Git
* GitHub

---

# 📂 프로젝트 구조

```plaintext
common
 └─ 공통 응답 객체(ApiResponse)

controller
 └─ API 요청 처리

service
 └─ 비즈니스 로직

repository
 └─ JPA Repository

entity
 └─ DB Entity

dto
 └─ Request / Response DTO

exception
 └─ 전역 예외 처리

security
 ├─ SecurityConfig
 ├─ JwtProvider
 └─ JwtAuthenticationFilter

user
 ├─ User
 ├─ UserController
 ├─ UserService
 ├─ UserRepository
 ├─ UserSignupRequest
 ├─ UserLoginRequest
 ├─ UserResponse
 └─ LoginResponse
```

---

# ✨ 구현 기능

## 문의 관리

* 문의 등록
* 문의 전체 조회
* 문의 단건 조회
* 문의 수정
* 문의 삭제

## 검색 기능

* 제목 검색
* 카테고리 검색
* 상태 검색
* 복합 조건 검색

## 페이징

* Pageable 기반 페이징
* 검색 + 페이징

## 사용자 관리

### 회원가입

* 이메일 중복 체크
* BCrypt 비밀번호 암호화
* 사용자 상태 관리
* 사용자 권한 관리

### 로그인

* 이메일 인증
* 비밀번호 검증
* JWT Access Token 발급

---

# 🔐 JWT 인증

로그인 성공 시 JWT 토큰을 발급합니다.

### 로그인 응답 예시

```json
{
  "success": true,
  "message": "로그인 성공",
  "data": {
    "accessToken": "eyJhbGciOi..."
  }
}
```

### 인증 방식

```http
Authorization: Bearer {JWT_TOKEN}
```

### 구현 완료 항목

* JWT Access Token 발급
* JWT 토큰 검증
* JwtAuthenticationFilter 구현
* Authorization Header 인증 처리
* SecurityContext 인증 등록

---

# 📖 API 문서

Swagger UI

```plaintext
http://localhost:8080/swagger-ui/index.html
```

---

# 📈 진행 현황

## Inquiry

* [x] CRUD 구현
* [x] 검색 기능
* [x] 복합 검색
* [x] 페이징
* [x] 검색 + 페이징

## User

* [x] 회원가입
* [x] 로그인
* [x] BCrypt 암호화

## Security

* [x] Spring Security 적용
* [x] JWT Access Token 발급
* [x] JWT 토큰 검증
* [x] JWT 인증 필터 구현
* [x] Authorization Header 인증 처리
* [x] SecurityContext 인증 등록

---

# 🚧 다음 개발 예정

* [ ] 현재 로그인 사용자 조회 (/users/me)
* [ ] Role 기반 권한 관리
* [ ] 관리자 기능 구현
* [ ] Refresh Token 적용
* [ ] AI 문의 자동 응답 기능

---

# 💡 학습 포인트

이 프로젝트를 통해 다음 기술을 학습했습니다.

* Spring Boot REST API 설계
* JPA 기반 데이터 처리
* Validation
* Global Exception Handling
* Swagger 문서화
* Spring Security
* JWT 인증 구조
* Filter 기반 인증 처리
* SecurityContext 활용

```
```
