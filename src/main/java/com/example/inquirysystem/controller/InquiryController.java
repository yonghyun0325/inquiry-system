package com.example.inquirysystem.controller;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.service.InquiryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@Tag(name = "Inquiry API", description = "문의 관리 API")
@RestController
public class InquiryController {

    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }


    @PostMapping("/inquiries")
    @Operation(summary = "문의 등록", description = "새로운 문의를 등록합니다.")
    public ApiResponse<InquiryResponse> createInquiry(
            @Valid @RequestBody InquiryRequest request
    ) {
        return inquiryService.createInquiry(request);
    }

    @GetMapping("/inquiries")
    @Operation(summary = "문의 전체 조회", description = "전체 문의 목록을 조회합니다.")
    public ApiResponse<List<InquiryResponse>> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/inquiries/search")
    @Operation(summary = "문의 검색", description = "조건 기반 문의 검색")
    public ApiResponse<List<InquiryResponse>> searchInquiries(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String status
    ) {
        return inquiryService.searchInquiries(title, category, status);
    }

    @GetMapping("/inquiries/search/page")
    @Operation(summary = "문의 페이징 조회", description = "페이지 기반 문의 조회")
    public ApiResponse<Page<InquiryResponse>> searchInquiriesWithPaging(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String status,
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable
    ) {
        return inquiryService.searchInquiriesWithPaging(
                title,
                category,
                status,
                pageable
        );
    }

    @GetMapping("/inquiries/{id}")
    @Operation(summary = "문의 단건 조회", description = "페이지 단건 조회")
    public ApiResponse<InquiryResponse> getInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.getInquiry(id);
    }

    @PutMapping("/inquiries/{id}")
    @Operation(summary = "문의 수정", description = "문의 수정")
    public ApiResponse<InquiryResponse> updateInquiry(
            @PathVariable Long id,
            @Valid @RequestBody InquiryRequest request
    ) {
        return inquiryService.updateInquiry(id, request);
    }

    @DeleteMapping("/inquiries/{id}")
    @Operation(summary = "문의 삭제", description = "문의 삭제")
    public ApiResponse<Void> deleteInquiry(
            @PathVariable Long id
    ) {
        return inquiryService.deleteInquiry(id);
    }


}