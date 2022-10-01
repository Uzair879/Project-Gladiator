package com.lti.service;

import java.util.List;

import com.lti.entity.SeatBooking;
import com.lti.exceptions.NoSeatBookingFoundException;


public interface SeatBookingService {
	
	public SeatBooking createSeatBooking(SeatBooking s);

	public List<SeatBooking> listOfSeatBooking();
	
	public SeatBooking findSeatBookingById(int sb_id) throws NoSeatBookingFoundException;
	
	public List<SeatBooking> getBookingsFor(int flight_id);
	
	public List<SeatBooking> getBookingsFor(int flight_id,String type);
	
	public void updateDetails(int user_id,List<Integer> sb_list);
	
	
}