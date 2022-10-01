package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name = "FD1")

public class Flight {
	
	
	@Id
	@SequenceGenerator(name = "flightSeqGen", sequenceName = "flightSeq", initialValue = 501, allocationSize = 1)
	@GeneratedValue(generator = "flight_id")
	private int flight_id;
	private String flight_name;
    private String flight_to;
    private String flight_from;
	private String flight_cabin;
	private LocalDate flight_arrival;
	private LocalDate flight_departure;
	private int flight_duration;
	private int flight_no_es;
	private int flight_no_bs;
	private int flight_es_price; //economy seats
	private int flight_bs_price; //business seats
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getFlight_to() {
		return flight_to;
	}
	public void setFlight_to(String flight_to) {
		this.flight_to = flight_to;
	}
	public String getFlight_from() {
		return flight_from;
	}
	public void setFlight_from(String flight_from) {
		this.flight_from = flight_from;
	}
	public String getFlight_cabin() {
		return flight_cabin;
	}
	public void setFlight_cabin(String flight_cabin) {
		this.flight_cabin = flight_cabin;
	}
	public LocalDate getFlight_arrival() {
		return flight_arrival;
	}
	public void setFlight_arrival(LocalDate flight_arrival) {
		this.flight_arrival = flight_arrival;
	}
	public LocalDate getFlight_departure() {
		return flight_departure;
	}
	public void setFlight_departure(LocalDate flight_departure) {
		this.flight_departure = flight_departure;
	}
	public int getFlight_duration() {
		return flight_duration;
	}
	public void setFlight_duration(int flight_duration) {
		this.flight_duration = flight_duration;
	}
	public int getFlight_no_es() {
		return flight_no_es;
	}
	public void setFlight_no_es(int flight_no_es) {
		this.flight_no_es = flight_no_es;
	}
	public int getFlight_no_bs() {
		return flight_no_bs;
	}
	public void setFlight_no_bs(int flight_no_bs) {
		this.flight_no_bs = flight_no_bs;
	}
	public int getFlight_es_price() {
		return flight_es_price;
	}
	public void setFlight_es_price(int flight_es_price) {
		this.flight_es_price = flight_es_price;
	}
	public int getFlight_bs_price() {
		return flight_bs_price;
	}
	public void setFlight_bs_price(int flight_bs_price) {
		this.flight_bs_price = flight_bs_price;
	}
	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", flight_to=" + flight_to
				+ ", flight_from=" + flight_from + ", flight_cabin=" + flight_cabin + ", flight_arrival="
				+ flight_arrival + ", flight_departure=" + flight_departure + ", flight_duration=" + flight_duration
				+ ", flight_no_es=" + flight_no_es + ", flight_no_bs=" + flight_no_bs + ", flight_es_price="
				+ flight_es_price + ", flight_bs_price=" + flight_bs_price + "]";
	}
	
}
	