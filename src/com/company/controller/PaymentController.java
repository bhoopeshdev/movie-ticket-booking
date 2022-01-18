package com.company.controller;

import com.company.entity.Payment;
import com.company.service.PaymentService;

public class PaymentController {

    private final PaymentService paymentService = new PaymentService();

    public Payment createPayment(Long bookingId, Long currencyValue, Long userId) {
        return paymentService.createPayment(bookingId,currencyValue,userId);
    }
}
