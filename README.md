# Inquiry System

Spring Boot + JPA + MySQL 기반 문의 관리 시스템입니다.

REST API 기반 CRUD 기능을 구현하였으며,
실무형 백엔드 구조를 목표로 개발 중입니다.

---

# Tech Stack

- Java 17
- Spring Boot 4
- Spring Data JPA
- MySQL
- Gradle
- Postman

---

# Project Structure

## controller
- API 요청 처리

## service
- 비즈니스 로직 처리

## repository
- DB 접근

## entity
- DB 테이블 매핑

## dto
- Request / Response 데이터 처리

---

# Features

- 문의 등록(Create)
- 문의 전체 조회(Read)
- 문의 단건 조회(Read)
- 문의 수정(Update)
- 문의 삭제(Delete)

---

# API

## 문의 등록
POST /inquiries

## 문의 전체 조회
GET /inquiries

## 문의 단건 조회
GET /inquiries/{id}

## 문의 수정
PUT /inquiries/{id}

## 문의 삭제
DELETE /inquiries/{id}

---

# Inquiry Entity

- id
- category
- title
- content
- customerName
- customerEmail
- status
- createdAt
- updatedAt

---

# Current Progress

- Spring Boot 프로젝트 생성
- MySQL 연동 완료
- JPA 설정 완료
- CRUD API 구현 완료
- DTO 분리(Request / Response)
- Entity 설계 및 확장
- Postman API 테스트 완료

---

# Next Step

- Validation 적용
- Exception Handling
- 페이징 처리
- 검색 기능
- JWT 로그인
- 관리자 기능
- AI 문의 답변 기능

---

# Goal

단순 CRUD 프로젝트가 아닌,
실무형 백엔드 아키텍처 및 REST API 설계를 목표로 개발 중입니다.
