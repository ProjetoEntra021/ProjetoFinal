package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
