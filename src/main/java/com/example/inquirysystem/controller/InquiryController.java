package com.example.inquirysystem.controller;

import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.service.InquiryService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

@RestController
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping("/inquiries")
    public Map<String, String> createInquiry(
            @Valid @RequestBody InquiryRequest request
    ) {

        return inquiryService.createInquiry(request);
    }

    @GetMapping("/inquiries")
    public List<InquiryResponse> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/inquiries/{id}")
    public InquiryResponse getInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.getInquiry(id);
    }

    @PutMapping("/inquiries/{id}")
    public InquiryResponse updateInquiry(
            @PathVariable Long id,
            @RequestBody InquiryRequest request
    ) {

        return inquiryService.updateInquiry(id, request);
    }

    @DeleteMapping("/inquiries/{id}")
    public Map<String, String> deleteInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.deleteInquiry(id);
    }
}