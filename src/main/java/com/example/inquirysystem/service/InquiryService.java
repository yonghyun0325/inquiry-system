package com.example.inquirysystem.service;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.dto.InquiryRequest;
import com.example.inquirysystem.dto.InquiryResponse;
import com.example.inquirysystem.entity.Inquiry;
import com.example.inquirysystem.repository.InquiryRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.inquirysystem.dto.AdminInquiryResponse;
import com.example.inquirysystem.dto.InquiryStatusUpdateRequest;
import com.example.inquirysystem.dto.InquiryAnswerUpdateRequest;
import com.example.inquirysystem.dto.AdminDashboardResponse;
import com.example.inquirysystem.user.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    public InquiryService(InquiryRepository inquiryRepository,UserRepository userRepository)
    {
        this.inquiryRepository = inquiryRepository;
        this.userRepository = userRepository;
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

    // 문의 복합 검색
    public ApiResponse<List<InquiryResponse>> searchInquiries(
            String title,
            String category,
            String status
    ) {

        List<InquiryResponse> inquiries =
                inquiryRepository.searchInquiries(
                                title,
                                category,
                                status
                        )
                        .stream()
                        .map(InquiryResponse::new)
                        .toList();

        return new ApiResponse<>(
                true,
                "문의 검색 성공",
                inquiries
        );
    }

    // 문의 복합 검색 + 페이징
    public ApiResponse<Page<InquiryResponse>> searchInquiriesWithPaging(
            String title,
            String category,
            String status,
            Pageable pageable
    ) {

        Page<InquiryResponse> inquiries =
                inquiryRepository.searchInquiriesWithPaging(
                                title,
                                category,
                                status,
                                pageable
                        )
                        .map(InquiryResponse::new);

        return new ApiResponse<>(
                true,
                "문의 검색 페이징 조회 성공",
                inquiries
        );
    }

    // 관리자 문의 목록 조회
    public ApiResponse<List<AdminInquiryResponse>> getAllInquiriesForAdmin() {

        List<AdminInquiryResponse> inquiries = inquiryRepository.findAll()
                .stream()
                .map(AdminInquiryResponse::new)
                .toList();

        return new ApiResponse<>(
                true,
                "관리자 문의 목록 조회 성공",
                inquiries
        );
    }

    // 관리자 문의 상태 변경
    public ApiResponse<String> updateInquiryStatus(
            Long id,
            InquiryStatusUpdateRequest request
    ) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("문의를 찾을 수 없습니다.")
                );

        inquiry.setStatus(request.getStatus());

        inquiryRepository.save(inquiry);

        return new ApiResponse<>(
                true,
                "문의 상태 변경 성공",
                inquiry.getStatus()
        );
    }
    // 관리자 문의 답변 등록
    public ApiResponse<String> updateInquiryAnswer(
            Long id,
            InquiryAnswerUpdateRequest request
    ) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("문의를 찾을 수 없습니다.")
                );

        inquiry.setAnswer(request.getAnswer());

        // 답변 등록 시 상태 자동 변경
        inquiry.setStatus("COMPLETED");

        inquiryRepository.save(inquiry);

        return new ApiResponse<>(
                true,
                "문의 답변 등록 성공",
                inquiry.getAnswer()
        );
    }

    // 관리자 문의 상세 조회
    public ApiResponse<AdminInquiryResponse> getInquiryForAdmin(Long id) {

        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("문의를 찾을 수 없습니다.")
                );

        return new ApiResponse<>(
                true,
                "관리자 문의 상세 조회 성공",
                new AdminInquiryResponse(inquiry)
        );
    }

    // 관리자 대시보드 조회
    public ApiResponse<AdminDashboardResponse> getAdminDashboard() {

        long totalUsers = userRepository.count();

        long activeUsers =
                userRepository.countByStatus("ACTIVE");

        long inactiveUsers =
                userRepository.countByStatus("INACTIVE");

        long totalInquiries =
                inquiryRepository.count();

        long requestedCount =
                inquiryRepository.countByStatus("REQUESTED");

        long completedCount =
                inquiryRepository.countByStatus("COMPLETED");

        LocalDateTime todayStart =
                LocalDate.now().atStartOfDay();

        LocalDateTime todayEnd =
                todayStart.plusDays(1);

        long todayInquiries =
                inquiryRepository.countByCreatedAtBetween(
                        todayStart,
                        todayEnd
                );

        double completionRate = 0.0;

        if (totalInquiries > 0) {
            completionRate =
                    (double) completedCount
                            / totalInquiries
                            * 100;
        }

        AdminDashboardResponse response =
                new AdminDashboardResponse(
                        totalUsers,
                        activeUsers,
                        inactiveUsers,
                        totalInquiries,
                        requestedCount,
                        completedCount,
                        todayInquiries,
                        completionRate
                );

        return new ApiResponse<>(
                true,
                "관리자 대시보드 조회 성공",
                response
        );
    }
}