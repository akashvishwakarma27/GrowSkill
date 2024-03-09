package com.GrowSkil.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GrowSkil.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}