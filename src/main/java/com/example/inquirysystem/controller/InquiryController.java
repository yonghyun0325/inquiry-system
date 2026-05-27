package com.example.inquirysystem.controller;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.service.InquiryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping("/inquiries")
    public ApiResponse<InquiryResponse> createInquiry(
            @Valid @RequestBody InquiryRequest request
    ) {
        return inquiryService.createInquiry(request);
    }

    @GetMapping("/inquiries")
    public ApiResponse<List<InquiryResponse>> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/inquiries/search")
    public ApiResponse<List<InquiryResponse>> searchByTitle(
            @RequestParam String title
    ) {
        return inquiryService.searchByTitle(title);
    }

    @GetMapping("/inquiries/page")
    public ApiResponse<Page<InquiryResponse>> getInquiriesWithPaging(
            Pageable pageable
    ) {
        return inquiryService.getInquiriesWithPaging(pageable);
    }

    @GetMapping("/inquiries/{id}")
    public ApiResponse<InquiryResponse> getInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.getInquiry(id);
    }

    @PutMapping("/inquiries/{id}")
    public ApiResponse<InquiryResponse> updateInquiry(
            @PathVariable Long id,
            @Valid @RequestBody InquiryRequest request
    ) {
        return inquiryService.updateInquiry(id, request);
    }

    @DeleteMapping("/inquiries/{id}")
    public ApiResponse<Void> deleteInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.deleteInquiry(id);
    }


}