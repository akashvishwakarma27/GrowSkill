package com.GrowSkil.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GrowSkil.entity.Course;
import com.GrowSkil.entity.Payment;
import com.GrowSkil.entity.User;
import com.GrowSkil.exception.PaymentNotFoundException;
import com.GrowSkil.repository.CourseRepository;
import com.GrowSkil.repository.PaymentRepository;
import com.GrowSkil.repository.UserRepository;
import com.GrowSkil.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Payment processPayment(int userId, int courseId, double amount) throws PaymentNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new PaymentNotFoundException("User with ID " + userId + " not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new PaymentNotFoundException("Course with ID " + courseId + " not found"));

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setCourse(course);
        payment.setAmount(amount);
        payment.setPaymentStatus("Completed"); 
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(int paymentId) throws PaymentNotFoundException {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + paymentId + " not found"));
    }
}

