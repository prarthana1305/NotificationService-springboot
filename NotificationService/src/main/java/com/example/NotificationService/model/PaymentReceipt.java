package com.example.NotificationService.model;


import lombok.Data;

@Data
public class PaymentReceipt {
    private Long userId;
    private String email;
    private double amount;

    public PaymentReceipt(Long userId, String email, double amount) {
        this.userId = userId;
        this.email = email;
        this.amount = amount;
    }
    public PaymentReceipt() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    // Additional fields can be added if necessary
}
