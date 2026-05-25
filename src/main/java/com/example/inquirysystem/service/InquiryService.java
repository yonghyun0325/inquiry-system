package com.example.inquirysystem.service;

import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.entity.Inquiry;
import com.example.inquirysystem.repository.InquiryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public Map<String, String> createInquiry(InquiryRequest request) {

        Inquiry inquiry = new Inquiry();

        inquiry.setCategory(request.getCategory());
        inquiry.setTitle(request.getTitle());
        inquiry.setContent(request.getContent());
        inquiry.setCustomerName(request.getCustomerName());
        inquiry.setCustomerEmail(request.getCustomerEmail());
        inquiry.setStatus("REQUESTED");

        LocalDateTime now = LocalDateTime.now().withNano(0);

        inquiry.setCreatedAt(now);
        inquiry.setUpdatedAt(now);

        inquiryRepository.save(inquiry);

        Map<String, String> response = new HashMap<>();
        response.put("message", "DB 저장 완료");

        return response;
    }

    public List<InquiryResponse> getAllInquiries() {
        return inquiryRepository.findAll()
                .stream()
                .map(InquiryResponse::new)
                .toList();
    }

    public InquiryResponse getInquiry(Long id) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("문의가 없습니다."));

        return new InquiryResponse(inquiry);
    }

    public InquiryResponse updateInquiry(
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
        inquiry.setUpdatedAt(LocalDateTime.now());

        Inquiry updatedInquiry = inquiryRepository.save(inquiry);

        return new InquiryResponse(updatedInquiry);
    }

    public Map<String, String> deleteInquiry(Long id) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("문의가 없습니다."));

        inquiryRepository.delete(inquiry);

        Map<String, String> response = new HashMap<>();
        response.put("message", "삭제 완료");

        return response;
    }
}