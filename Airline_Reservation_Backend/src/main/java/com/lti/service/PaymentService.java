package com.lti.service;

import java.util.List;


import com.lti.entity.Payment;
import com.lti.exceptions.NoPaymentFoundException;


public interface PaymentService {
	public Payment createPayments(Payment s);
	public List<Payment> listOfPayments();
	public Payment findPaymentsById(int id) throws NoPaymentFoundException;
	public Payment deletePaymentById(int id) throws NoPaymentFoundException;
	public Payment findPaymentsByAmount(float famount) throws NoPaymentFoundException;
}
