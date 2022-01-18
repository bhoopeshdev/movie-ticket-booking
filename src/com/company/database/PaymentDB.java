package com.company.database;

import com.company.entity.Payment;

import java.util.HashMap;

public class PaymentDB {

    private static volatile PaymentDB paymentDB;
    private final HashMap<Long, Payment> paymentMap;

    private PaymentDB() {
        paymentMap = new HashMap<>();
    }
    public static PaymentDB getInstance() {
        if(paymentDB == null) {
            synchronized (PaymentDB.class) {
                if(paymentDB == null) {
                    paymentDB = new PaymentDB();
                }
            }
        }
        return paymentDB;
    }

    public Payment savePayment(Payment payment) {
        paymentMap.put(payment.getPaymentId(),new Payment(payment));
        return payment;
    }

    public Payment getPayment(Long paymentId) {
        if(paymentMap.containsKey(paymentId)) {
            return paymentMap.get(paymentId);
        }
        return null;
    }
}
