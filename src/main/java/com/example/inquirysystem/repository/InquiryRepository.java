package com.example.inquirysystem.repository;

import com.example.inquirysystem.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    List<Inquiry> findByTitleContaining(String title);

    long countByStatus(String status);

    @Query("""
        SELECT i
        FROM Inquiry i
        WHERE (:title IS NULL OR i.title LIKE %:title%)
          AND (:category IS NULL OR i.category = :category)
          AND (:status IS NULL OR i.status = :status)
        """)
    Page<Inquiry> searchInquiriesWithPaging(
            @Param("title") String title,
            @Param("category") String category,
            @Param("status") String status,
            Pageable pageable
    );
    @Query("""
        SELECT i
        FROM Inquiry i
        WHERE (:title IS NULL OR i.title LIKE %:title%)
          AND (:category IS NULL OR i.category = :category)
          AND (:status IS NULL OR i.status = :status)
        """)
    List<Inquiry> searchInquiries(
            @Param("title") String title,
            @Param("category") String category,
            @Param("status") String status
    );
    long countByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}