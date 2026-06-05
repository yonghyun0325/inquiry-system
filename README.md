# 🚀 AI Inquiry & Schedule Management Platform

사용자의 문의를 효율적으로 관리하고, 관리자 기능을 통해 문의 처리 현황을 모니터링하며, 향후 AI 기반 자동 답변 기능과 일정 관리 기능까지 확장 가능한 백엔드 플랫폼입니다.

본 프로젝트는 단순 CRUD 구현을 넘어 실제 서비스 환경에서 사용되는 인증(Authentication), 권한 인가(Authorization), 관리자(Admin) 기능, 통계 대시보드 구조를 직접 설계하고 구현하는 것을 목표로 개발했습니다.

---

# 🎯 Project Goal

본 프로젝트를 통해 다음과 같은 실무 역량을 학습하고 적용했습니다.

* Spring Boot 기반 REST API 설계
* Spring Security 기반 인증/인가 구현
* JWT 기반 로그인 및 권한 관리
* JPA 기반 데이터 관리
* 관리자(Admin) 기능 구현
* 통계 대시보드 구현
* AI 자동 응답 기능 확장 고려
* 일정 관리 기능 확장 고려

---

# 🏗 System Architecture

```plaintext
[ User ]

회원가입
 ↓
로그인
 ↓
JWT 발급
 ↓
문의 등록 / 조회
 ↓
DB 저장

--------------------------------

[ Admin ]

JWT 인증
 ↓
회원 관리
 ↓
문의 관리
 ↓
답변 등록
 ↓
대시보드 조회

--------------------------------

[ Future AI ]

문의 분석
 ↓
자동 분류
 ↓
자동 답변 생성

--------------------------------

[ Future Schedule ]

일정 등록
일정 수정
일정 조회
일정 삭제
```

---

# 🛠 Tech Stack

## Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* JWT
* Validation

## Database

* MySQL

## Documentation

* Swagger(OpenAPI)

## Build Tool

* Gradle

## Version Control

* Git
* GitHub

---

# ✨ Key Features

## 👤 User

* 회원가입
* 로그인
* JWT 인증
* 내 정보 조회
* 문의 등록
* 문의 조회
* 문의 수정
* 문의 삭제

---

## 🛡 Admin

### User Management

* 회원 목록 조회
* 사용자 권한 변경
* 사용자 상태 변경

### Inquiry Management

* 문의 목록 조회
* 문의 상세 조회
* 문의 상태 변경
* 문의 답변 등록

### Dashboard

* 전체 회원 수 조회
* 활성 회원 수 조회
* 비활성 회원 수 조회
* 전체 문의 수 조회
* 처리 대기 문의 수 조회
* 처리 완료 문의 수 조회
* 오늘 접수 문의 수 조회
* 문의 처리율 조회

---

# 🔐 Authentication & Authorization

본 프로젝트는 Spring Security와 JWT를 활용하여 인증 및 권한 관리를 구현했습니다.

## Authentication Flow

```plaintext
로그인
 ↓
JWT Access Token 발급
 ↓
Authorization Header 전달
 ↓
JwtAuthenticationFilter 검증
 ↓
SecurityContext 등록
 ↓
인증 완료
```

## Authorization

```plaintext
ROLE_USER
ROLE_ADMIN
```

관리자 API는 ROLE_ADMIN 사용자만 접근할 수 있도록 구현했습니다.

---

# 📊 Dashboard

관리자 대시보드 통계 기능을 구현했습니다.

### Dashboard Response Example

```json
{
  "totalUsers": 2,
  "activeUsers": 1,
  "inactiveUsers": 0,
  "totalInquiries": 7,
  "requestedCount": 6,
  "completedCount": 1,
  "todayInquiries": 0,
  "completionRate": 14.28
}
```

---

# 📌 Entity Design

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

---

# 🌐 API Endpoints

## Inquiry API

| Method | URL                    | Description |
| ------ | ---------------------- | ----------- |
| POST   | /inquiries             | 문의 등록       |
| GET    | /inquiries             | 문의 전체 조회    |
| GET    | /inquiries/{id}        | 문의 단건 조회    |
| PUT    | /inquiries/{id}        | 문의 수정       |
| DELETE | /inquiries/{id}        | 문의 삭제       |
| GET    | /inquiries/search      | 문의 검색       |
| GET    | /inquiries/page        | 문의 페이징 조회   |
| GET    | /inquiries/search/page | 검색 + 페이징 조회 |

## User API

| Method | URL           | Description |
| ------ | ------------- | ----------- |
| POST   | /users/signup | 회원가입        |
| POST   | /users/login  | 로그인         |
| GET    | /users/me     | 내 정보 조회     |

## Admin API

| Method | URL                          | Description |
| ------ | ---------------------------- | ----------- |
| GET    | /admin/dashboard             | 관리자 대시보드    |
| GET    | /admin/users                 | 회원 목록 조회    |
| PATCH  | /admin/users/{id}/role       | 사용자 권한 변경   |
| PATCH  | /admin/users/{id}/status     | 사용자 상태 변경   |
| GET    | /admin/inquiries             | 문의 목록 조회    |
| GET    | /admin/inquiries/{id}        | 문의 상세 조회    |
| PATCH  | /admin/inquiries/{id}/status | 문의 상태 변경    |
| PATCH  | /admin/inquiries/{id}/answer | 문의 답변 등록    |

---

# 📈 Current Progress

## Completed

* Spring Boot 프로젝트 구축
* JPA CRUD 구현
* 검색 및 페이징 구현
* JWT 인증 구현
* ROLE 기반 권한 관리
* 관리자 회원 관리
* 관리자 문의 관리
* 관리자 대시보드
* Swagger 문서화
* Global Exception Handling
* Validation 적용

## In Progress

* Refresh Token 적용
* AI 문의 자동 응답
* AI 문의 자동 분류
* 일정 관리(Schedule Management)

---

# 🔮 Future Plans

## Security

* Refresh Token
* Access Token 재발급
* 로그아웃 기능

## AI

* OpenAI API 연동
* AI 문의 자동 답변
* AI 문의 자동 분류
* AI 답변 추천

## Schedule

* 일정 등록
* 일정 조회
* 일정 수정
* 일정 삭제
* 사용자별 일정 관리
* 캘린더 조회 기능

---

# 🚀 Project Status

```plaintext
CRUD                    ✅ 완료
검색                    ✅ 완료
페이징                  ✅ 완료

회원가입                ✅ 완료
로그인                  ✅ 완료
JWT 인증                ✅ 완료
JWT 권한 관리           ✅ 완료

관리자 회원 관리         ✅ 완료
관리자 문의 관리         ✅ 완료
관리자 대시보드         ✅ 완료

Refresh Token           ⏳ 진행 예정
AI 문의 자동 응답        ⏳ 진행 예정
일정 관리               ⏳ 진행 예정
```
