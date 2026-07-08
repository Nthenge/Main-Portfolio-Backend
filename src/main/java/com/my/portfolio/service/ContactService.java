package com.my.portfolio.service;

import com.my.portfolio.dto.ContactRequest;
import com.my.portfolio.model.EmailSubmission;
import com.my.portfolio.repository.EmailSubmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private final EmailSubmissionRepository submissionRepository;
    private final BrevoEmailService emailService;

    public ContactService(EmailSubmissionRepository submissionRepository, BrevoEmailService emailService) {
        this.submissionRepository = submissionRepository;
        this.emailService = emailService;
    }

    public void handleContactRequest(ContactRequest request) {
        submissionRepository.save(new EmailSubmission(
                request.name(), request.email(), request.budget(),
                request.service(), request.description()
        ));

        emailService.sendNotificationToOwner(request);

        try {
            emailService.sendConfirmationToRequester(request);
        } catch (Exception ex) {
            log.warn("Confirmation email to {} failed: {}", request.email(), ex.getMessage());
        }
    }

    public List<EmailSubmission> getAllSubmissions() {
        return submissionRepository.findAllByOrderByCreatedAtDesc();
    }
}
