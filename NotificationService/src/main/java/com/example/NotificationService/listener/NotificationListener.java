package com.example.NotificationService.listener;


import com.example.NotificationService.model.PaymentReceipt;
import com.example.NotificationService.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component

public class NotificationListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);
    private final EmailService emailService;

    public NotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "notification.payment.success.queue")
    public void handlePaymentSuccess(PaymentReceipt receipt) {
        log.info("Received payment success notification: {}", receipt);
        emailService.sendEmail(receipt.getEmail(), "Payment Success", "Your payment of $" + receipt.getAmount() + " was successful.");
    }

    @RabbitListener(queues = "notification.penalty.queue")
    public void handlePenalty(String penaltyMessage) {
        log.info("Received penalty notification: {}", penaltyMessage);
        // For example, send an email alert for a penalty
        emailService.sendEmail("support@example.com", "Penalty Alert", penaltyMessage);
    }

    @RabbitListener(queues = "notification.sos.queue")
    public void handleSOSAlert(String sosMessage) {
        log.info("Received SOS notification: {}", sosMessage);
        // For example, notify an emergency contact
        emailService.sendEmail("sos@example.com", "SOS Alert", sosMessage);
    }
}
