package com.example.NotificationService.controller;

import com.example.NotificationService.dto.NotificationRequestDTO;
import com.example.NotificationService.dto.NotificationResponseDTO;
import com.example.NotificationService.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")


public class NotificationController {
    private final EmailService emailService;
    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping("/send")
    public ResponseEntity<NotificationResponseDTO> sendNotification(@RequestBody NotificationRequestDTO requestDTO) {
        final Logger log = LoggerFactory.getLogger(NotificationController.class);
        log.info("Received notification request for email: {}", requestDTO.getTo());
        boolean success = emailService.sendEmail(requestDTO.getTo(), requestDTO.getSubject(), requestDTO.getBody());
        NotificationResponseDTO responseDTO = new NotificationResponseDTO();
        if (success) {
            responseDTO.setStatus("SUCCESS");
            responseDTO.setMessage("Email sent successfully");
        } else {
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Failed to send email");
        }
        return ResponseEntity.ok(responseDTO);
    }
}
