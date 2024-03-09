package com.GrowSkil.service;

import com.GrowSkil.entity.Payment;
import com.GrowSkil.exception.PaymentNotFoundException;

public interface PaymentService {
    Payment processPayment(int userId, int courseId, double amount) throws PaymentNotFoundException;
    Payment getPaymentById(int paymentId) throws PaymentNotFoundException;
}
