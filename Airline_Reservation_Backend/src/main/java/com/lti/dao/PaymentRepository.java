package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lti.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	Payment findByPaymentAmount(float paymentAmount);
	

}
