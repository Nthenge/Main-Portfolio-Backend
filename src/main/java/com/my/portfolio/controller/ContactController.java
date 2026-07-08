package com.my.portfolio.controller;

import com.my.portfolio.dto.ContactRequest;
import com.my.portfolio.model.EmailSubmission;
import com.my.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> submitContact(@Valid @RequestBody ContactRequest request) {
        contactService.handleContactRequest(request);

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Thanks! Your message has been sent."
        ));
    }

    @GetMapping("/submissions")
    public List<EmailSubmission> getSubmissions() {
        return contactService.getAllSubmissions();
    }
}
