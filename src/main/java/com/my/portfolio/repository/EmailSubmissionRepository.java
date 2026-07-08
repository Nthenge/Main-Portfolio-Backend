package com.my.portfolio.repository;

import com.my.portfolio.model.EmailSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailSubmissionRepository extends JpaRepository<EmailSubmission, Long> {
    List<EmailSubmission> findAllByOrderByCreatedAtDesc();
}
