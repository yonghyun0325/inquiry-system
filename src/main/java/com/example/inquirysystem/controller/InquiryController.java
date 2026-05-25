package com.example.inquirysystem.controller;

import com.example.inquirysystem.dto.InquiryRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InquiryController {

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping("/inquiries")
    public Map<String, String> createInquiry(
            @RequestBody InquiryRequest request
    ) {

        System.out.println("제목: " + request.getTitle());
        System.out.println("내용: " + request.getContent());

        Map<String, String> response = new HashMap<>();
        response.put("message", "등록 완료");

        return response;
    }
}