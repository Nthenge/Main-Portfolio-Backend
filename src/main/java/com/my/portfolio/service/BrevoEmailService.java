package com.my.portfolio.service;

import com.my.portfolio.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class BrevoEmailService {

    private final RestClient restClient;

    @Value("${brevo.sender.email}")
    private String senderEmail;

    @Value("${brevo.sender.name}")
    private String senderName;

    @Value("${brevo.owner.email}")
    private String ownerEmail;

    public BrevoEmailService(@Value("${brevo.api.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.brevo.com/v3")
                .defaultHeader("api-key", apiKey)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    public void sendNotificationToOwner(ContactRequest req) {
        String html = """
                <h3>New portfolio contact request</h3>
                <p><b>Name:</b> %s</p>
                <p><b>Email:</b> %s</p>
                <p><b>Plan:</b> %s</p>
                <p><b>Service:</b> %s</p>
                <p><b>Description:</b><br/>%s</p>
                """.formatted(req.name(), req.email(), req.budget(), req.service(), req.description());

        send(ownerEmail, "New contact request from " + req.name(), html);
    }

    public void sendConfirmationToRequester(ContactRequest req) {
        String html = """
            <p>Hi %s,</p>
            <p>Thanks for reaching out. I've received your message and will get back to you soon.</p>
            <p><b>Here's a copy of what you sent:</b></p>
            <p><b>Description:</b> %s</p>
            <p><b>Plan:</b> %s</p>
            <p><b>Service:</b> %s</p>
            <img src="https://pixabay.com/get/g95a1e736bed64dcdba86f812b4daeb06975f41c45baa80cebb15bd2afd5f809943b1c6fd22958dc6790629d760c98b55_1920.png?longlived=" alt="Abraham Mutinda" width="160" style="display:block;margin:16px 0;" />
            <p>Regards,<br/> Abraham Mutinda</p>
            """.formatted(req.name(), req.description(), req.budget(), req.service());

        send(req.email(), "Thanks for reaching out, " + req.name() + "!", html);
    }

    private void send(String toEmail, String subject, String htmlContent) {
        Map<String, Object> payload = Map.of(
                "sender", Map.of("name", senderName, "email", senderEmail),
                "to", List.of(Map.of("email", toEmail)),
                "subject", subject,
                "htmlContent", htmlContent
        );

        restClient.post()
                .uri("/smtp/email")
                .body(payload)
                .retrieve()
                .toBodilessEntity();
    }
}
