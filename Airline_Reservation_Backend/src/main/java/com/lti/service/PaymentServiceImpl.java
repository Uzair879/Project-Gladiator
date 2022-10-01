package com.lti.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.Payment;
import com.lti.dao.PaymentRepository;
import com.lti.exceptions.NoPaymentFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository s_repo;
	@Transactional
	@Override
	public Payment createPayments(Payment s) {
		return s_repo.save(s);
	}

	@Override
	public List<Payment> listOfPayments() {
		return s_repo.findAll();
	}

	@Override
	public Payment findPaymentsById(int id) throws NoPaymentFoundException {
		Payment temp=null;
		Optional<Payment> pFind = s_repo.findById(id);
		if(pFind.isPresent())
		{
			temp=pFind.get();
		}
		else
		{
			throw new NoPaymentFoundException("No Found");
		}
		return temp;
	}

	@Override
	public Payment deletePaymentById(int id) throws NoPaymentFoundException {
		Payment temp=null;
		Optional<Payment> pFind = s_repo.findById(id);
		if(pFind.isPresent())
		{
			temp=pFind.get();
			s_repo.deleteById(id);
		}
		else
		{
			throw new NoPaymentFoundException("No Found");
		}
		return temp;
	}

	@Override
	public Payment findPaymentsByAmount(float paymentAmount) throws NoPaymentFoundException {
		
		return s_repo.findByPaymentAmount(paymentAmount);
	}
	
	
	

}
	


