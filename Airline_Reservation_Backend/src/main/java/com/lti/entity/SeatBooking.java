package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name ="Seat_Booking_Table")
public class SeatBooking {
	
	@Id
	@SequenceGenerator(name = "seatSeqGen", sequenceName = "seatSeq", initialValue = 001, allocationSize = 1)
	@GeneratedValue(generator = "sb_id")
	private int sb_id;
	private String sb_seat_number;
	private String sb_type;
	private String sb_status;

	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "flight_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "user_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	public int getSb_id() {
		return sb_id;
	}

	public void setSb_id(int sb_id) {
		this.sb_id = sb_id;
	}

	public String getSb_seat_number() {
		return sb_seat_number;
	}

	public void setSb_seat_number(String sb_seat_number) {
		this.sb_seat_number = sb_seat_number;
	}

	public String getSb_type() {
		return sb_type;
	}

	public void setSb_type(String sb_type) {
		this.sb_type = sb_type;
	}

	public String getSb_status() {
		return sb_status;
	}

	public void setSb_status(String sb_status) {
		this.sb_status = sb_status;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SeatBooking [sb_id=" + sb_id + ", sb_seat_number=" + sb_seat_number + ", sb_type=" + sb_type
				+ ", sb_status=" + sb_status + ", flight=" + flight + ", user=" + user + "]";
	}
	
}