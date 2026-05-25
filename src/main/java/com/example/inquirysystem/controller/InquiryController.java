package com.example.inquirysystem.controller;

import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.service.InquiryService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(
            InquiryService inquiryService
    ) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping("/inquiries")
    public Map<String, String> createInquiry(
            @RequestBody InquiryRequest request
    ) {

        return inquiryService.createInquiry(request);
    }
}