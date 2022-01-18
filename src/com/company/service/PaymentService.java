package com.company.service;

import com.company.database.PaymentDB;
import com.company.entity.Payment;
import com.company.enums.PaymentStatus;

public class PaymentService {

    private final PaymentDB paymentDB = PaymentDB.getInstance();

    public Payment createPayment(long bookingId, long currencyValue,Long userId) {

        long paymentId = Math.round(Math.random() * Long.MAX_VALUE);
        Payment payment = new Payment(paymentId,bookingId, PaymentStatus.PENDING);

        long res = Math.round(Math.random());
        if (res == 0) {
            payment.setPaymentStatus(PaymentStatus.FAIL);
        }
        else {
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        }
        return paymentDB.savePayment(payment);
    }
}
