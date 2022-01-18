package com.company.entity;

import com.company.enums.PaymentStatus;

public class Payment {
    private Long paymentId;
    private Long bookingId;
    private PaymentStatus paymentStatus;

    public Payment(Long paymentId, Long bookingId, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentStatus = paymentStatus;
    }

    public Payment(Payment payment) {
        this.paymentId = payment.paymentId;
        this.bookingId = payment.bookingId;
        this.paymentStatus = payment.paymentStatus;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
