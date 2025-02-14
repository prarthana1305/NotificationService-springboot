package com.example.NotificationService.dto;

import lombok.Data;

@Data
public class NotificationRequestDTO {
    private String to;      // Recipient email address
    private String subject; // Email subject
    private String body;    // Email body/content

    public String getTo() {
        return to;
    }

    public NotificationRequestDTO(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public NotificationRequestDTO() {

    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
