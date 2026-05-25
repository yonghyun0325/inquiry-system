package com.example.inquirysystem.dto;

public class InquiryRequest {

    private String category;
    private String title;
    private String content;
    private String customerName;
    private String customerEmail;

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
}