package com.example.inquirysystem.controller;

import com.example.inquirysystem.common.ApiResponse;
import com.example.inquirysystem.service.InquiryService;
import com.example.inquirysystem.user.AdminUserResponse;
import com.example.inquirysystem.user.UserService;
import org.springframework.web.bind.annotation.*;
import com.example.inquirysystem.user.RoleUpdateRequest;
import com.example.inquirysystem.user.StatusUpdateRequest;
import com.example.inquirysystem.dto.AdminInquiryResponse;
import com.example.inquirysystem.dto.InquiryStatusUpdateRequest;
import com.example.inquirysystem.dto.InquiryAnswerUpdateRequest;
import com.example.inquirysystem.dto.AdminDashboardResponse;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final InquiryService inquiryService;

    public AdminController(UserService userService, InquiryService inquiryService) {
        this.userService = userService;
        this.inquiryService = inquiryService;
    }

    // 관리자 접근 테스트
    @GetMapping("/test")
    public String adminTest() {
        return "관리자 접근 성공";
    }

    // 관리자 회원 목록 조회
    @GetMapping("/users")
    public ApiResponse<List<AdminUserResponse>> getAllUsers() {
        return userService.getAllUsersForAdmin();
    }

    // 사용자 권한 변경
    @PatchMapping("/users/{id}/role")
    public ApiResponse<String> updateUserRole(
            @PathVariable Long id,
            @RequestBody RoleUpdateRequest request
    ) {
        return userService.updateUserRole(id, request);
    }

    // 사용자 상태 변경
    @PatchMapping("/users/{id}/status")
    public ApiResponse<String> updateUserStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateRequest request
    ) {
        return userService.updateUserStatus(id, request);
    }

    // 관리자 문의 목록 조회
    @GetMapping("/inquiries")
    public ApiResponse<List<AdminInquiryResponse>> getAllInquiriesForAdmin() {
        return inquiryService.getAllInquiriesForAdmin();
    }

    // 관리자 문의 상태 변경
    @PatchMapping("/inquiries/{id}/status")
    public ApiResponse<String> updateInquiryStatus(
            @PathVariable Long id,
            @RequestBody InquiryStatusUpdateRequest request
    ) {
        return inquiryService.updateInquiryStatus(id, request);
    }

    // 관리자 문의 답변 등록
    @PatchMapping("/inquiries/{id}/answer")
    public ApiResponse<String> updateInquiryAnswer(
            @PathVariable Long id,
            @RequestBody InquiryAnswerUpdateRequest request
    ) {
        return inquiryService.updateInquiryAnswer(id, request);
    }

    // 관리자 문의 상세 조회
    @GetMapping("/inquiries/{id}")
    public ApiResponse<AdminInquiryResponse> getInquiryForAdmin(
            @PathVariable Long id
    ) {
        return inquiryService.getInquiryForAdmin(id);
    }

    // 관리자 대시보드 조회
    @GetMapping("/dashboard")
    public ApiResponse<AdminDashboardResponse> getAdminDashboard() {
        return inquiryService.getAdminDashboard();
    }
}