package com.lti.entity;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="FlightPayment")
public class Payment {
	@Id
	private int payment_id;
	private float paymentAmount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date paymentDate;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public float getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", paymentAmount=" + paymentAmount + ", paymentDate=" + paymentDate
				+ "]";
	}
	
	

}
