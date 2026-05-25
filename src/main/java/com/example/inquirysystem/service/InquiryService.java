package com.example.inquirysystem.service;

import com.example.inquirysystem.dto.InquiryRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InquiryService {

    public Map<String, String> createInquiry(
            InquiryRequest request
    ) {

        System.out.println("제목: " + request.getTitle());
        System.out.println("내용: " + request.getContent());

        Map<String, String> response = new HashMap<>();
        response.put("message", "등록 완료");

        return response;
    }
}