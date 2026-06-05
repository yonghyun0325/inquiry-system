package com.example.inquirysystem.dto;

import com.example.inquirysystem.entity.Inquiry;

import java.time.LocalDateTime;

public class AdminInquiryResponse {

    private Long id;
    private String category;
    private String title;
    private String content;
    private String customerName;
    private String customerEmail;
    private String status;
    private String answer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AdminInquiryResponse(Inquiry inquiry) {
        this.id = inquiry.getId();
        this.category = inquiry.getCategory();
        this.title = inquiry.getTitle();
        this.content = inquiry.getContent();
        this.customerName = inquiry.getCustomerName();
        this.customerEmail = inquiry.getCustomerEmail();
        this.status = inquiry.getStatus();
        this.answer = inquiry.getAnswer();
        this.createdAt = inquiry.getCreatedAt();
        this.updatedAt = inquiry.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}