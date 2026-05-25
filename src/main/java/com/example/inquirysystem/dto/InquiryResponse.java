package com.example.inquirysystem.dto;

import com.example.inquirysystem.entity.Inquiry;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class InquiryResponse {

    private Long id;
    private String category;
    private String title;
    private String content;
    private String customerName;
    private String customerEmail;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public InquiryResponse(Inquiry inquiry) {
        this.id = inquiry.getId();
        this.category = inquiry.getCategory();
        this.title = inquiry.getTitle();
        this.content = inquiry.getContent();
        this.customerName = inquiry.getCustomerName();
        this.customerEmail = inquiry.getCustomerEmail();
        this.status = inquiry.getStatus();
        this.createdAt = inquiry.getCreatedAt();
        this.updatedAt = inquiry.getUpdatedAt();
    }

    public Long getId() { return id; }
    public String getCategory() { return category; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}