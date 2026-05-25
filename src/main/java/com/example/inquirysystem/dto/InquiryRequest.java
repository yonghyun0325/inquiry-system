package com.example.inquirysystem.dto;

public class InquiryRequest {

    private String title;
    private String content;

    public InquiryRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}