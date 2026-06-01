package com.example.inquirysystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // 관리자 접근 테스트
    @GetMapping("/test")
    public String adminTest() {
        return "관리자 접근 성공";
    }
}