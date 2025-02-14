package com.example.NotificationService.service;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service

public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
    // This method simulates sending an email and returns true if successful.
    public boolean sendEmail(String to, String subject, String body) {
        log.info("Sending email to: {} with subject: {} and body: {}", to, subject, body);
        // In a real implementation, you'd integrate with an email service.
        // For simulation, we assume it always succeeds.
        return true;
    }
}
