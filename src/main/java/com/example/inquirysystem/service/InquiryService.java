package com.example.inquirysystem.service;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.entity.Inquiry;
import com.example.inquirysystem.repository.InquiryRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository)
    {
        this.inquiryRepository = inquiryRepository;
    }

    // 문의 등록
    public ApiResponse<InquiryResponse> createInquiry(InquiryRequest request) {

        Inquiry inquiry = new Inquiry();

        inquiry.setCategory(request.getCategory());
        inquiry.setTitle(request.getTitle());
        inquiry.setContent(request.getContent());
        inquiry.setCustomerName(request.getCustomerName());
        inquiry.setCustomerEmail(request.getCustomerEmail());
        inquiry.setStatus("REQUESTED");

        Inquiry savedInquiry = inquiryRepository.save(inquiry);

        return new ApiResponse<>(
                true,
                "문의 등록 성공",
                new InquiryResponse(savedInquiry)
        );
    }

    // 문의 페이징 조회
    public ApiResponse<Page<InquiryResponse>> getInquiriesWithPaging(
            Pageable pageable
    ) {

        Page<InquiryResponse> inquiries =
                inquiryRepository.findAll(pageable)
                        .map(InquiryResponse::new);

        return new ApiResponse<>(
                true,
                "문의 페이징 조회 성공",
                inquiries
        );
    }

    // 문의 전체 조회
    public ApiResponse<List<InquiryResponse>> getAllInquiries() {
        List<InquiryResponse> inquiries = inquiryRepository.findAll()
                .stream()
                .map(InquiryResponse::new)
                .toList();

        return new ApiResponse<>(
                true,
                "문의 전체 조회 성공",
                inquiries
        );
    }

    // 문의 단건 조회
    public ApiResponse<InquiryResponse> getInquiry(Long id) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("문의가 없습니다.")
                );

        InquiryResponse response =
                new InquiryResponse(inquiry);

        return new ApiResponse<>(
                true,
                "문의 조회 성공",
                response
        );
    }

    // 문의 수정
    public ApiResponse<InquiryResponse> updateInquiry(
            Long id,
            InquiryRequest request
    ) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("문의가 없습니다.")
                );

        inquiry.setCategory(request.getCategory());
        inquiry.setTitle(request.getTitle());
        inquiry.setContent(request.getContent());
        inquiry.setCustomerName(request.getCustomerName());
        inquiry.setCustomerEmail(request.getCustomerEmail());

        Inquiry updatedInquiry = inquiryRepository.save(inquiry);

        return new ApiResponse<>(
                true,
                "문의 수정 성공",
                new InquiryResponse(updatedInquiry)
        );
    }

    // 문의 삭제
    public ApiResponse<Void> deleteInquiry(Long id) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("문의가 없습니다."));

        inquiryRepository.delete(inquiry);

        return new ApiResponse<>(
                true,
                "문의 삭제 성공",
                null
        );
    }

    // 문의 제목 검색
    public ApiResponse<List<InquiryResponse>> searchByTitle(
            String title
    ) {

        List<InquiryResponse> inquiries =
                inquiryRepository.findByTitleContaining(title)
                        .stream()
                        .map(InquiryResponse::new)
                        .toList();

        return new ApiResponse<>(
                true,
                "문의 검색 성공",
                inquiries
        );
    }
}