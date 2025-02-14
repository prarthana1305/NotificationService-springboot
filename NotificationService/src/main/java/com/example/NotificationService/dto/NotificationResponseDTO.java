package com.example.NotificationService.dto;


import lombok.Data;

@Data
public class NotificationResponseDTO {
    private String status;   // e.g., SUCCESS or FAILURE
    private String message;  // Additional message or error details

    public NotificationResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public NotificationResponseDTO() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
