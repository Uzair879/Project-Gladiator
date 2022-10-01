package com.lti.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.entity.Payment;
import com.lti.exceptions.NoPaymentFoundException;
import com.lti.service.PaymentService;
//@CrossOrigin(origins="https://localhost:4200")

@RestController
public class PaymentController {
@Autowired
private PaymentService pService;

	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment p)
	{
		return pService.createPayments(p);
	}

	@GetMapping("/payments")
	public List<Payment> getAllStudents()
	{
		return pService.listOfPayments();
		
	}
	
	@GetMapping("/payments/{id}")
	public Payment getSById(@PathVariable("id") int id) throws NoPaymentFoundException
	{
		return pService.findPaymentsById(id);
		
	}
	@GetMapping("/paymentsAmount/{id}")
	public Payment getSByAmount(@PathVariable("id") float id) throws NoPaymentFoundException
	{
		return pService.findPaymentsByAmount(id);
		
	}

//	
//	@PutMapping("/students/{u_id}")
//	public Student updateSById(@PathVariable("u_id") int u_id,@RequestBody Student s) throws NoStudentFoundException
//	{
//		return sService.updateStudentById(u_id, s);
//		
//	}
//	
	@DeleteMapping("/payments/{d_id}")
	public Payment deleteSById(@PathVariable("d_id") int d_id) throws NoPaymentFoundException
	{
		return pService.deletePaymentById(d_id);
		
	}
}
