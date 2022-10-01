package com.lti.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Flight;
import com.lti.entity.SeatBooking;
import com.lti.exceptions.NoSeatBookingFoundException;
import com.lti.service.SeatBookingService;

class BookingParameters
{
	
	    private List<Integer> seat_bookings;
	    private int user_id;
		public List<Integer> getSeat_bookings() {
			return seat_bookings;
		}
		public void setSeat_bookings(List<Integer> seat_bookings) {
			this.seat_bookings = seat_bookings;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		} 
	
}
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SeatBookingController {
	
	@Autowired
	private SeatBookingService sbService;
	@GetMapping("/seatbookings")
	public List<SeatBooking> getAllBookings()
	{
		return sbService.listOfSeatBooking();
	}
	
	@GetMapping("/flights/{flight_id}/seatbookings")
	public List<SeatBooking> getBookingsFor(@PathVariable("flight_id") int flight_id)
	{
		System.out.println("====================");
		System.out.println(flight_id);
// u1, f1, s1,s2 ==> /flights/f1/seatbookings {user_id: u1, seats: [s1,s2]}
		// 
		
		
		
		
		return sbService.getBookingsFor(flight_id);
	}
	
	@PostMapping("/flights/updateseatbookings")
	public void updateBooking(@RequestBody BookingParameters bp)
	{
		sbService.updateDetails(bp.getUser_id(),bp.getSeat_bookings());
	}
	
	@GetMapping("/seatbookings/{sb_id}")
	public SeatBooking getBookingById(@PathVariable("sb_id") int sb_id) throws NoSeatBookingFoundException 
	{
		return sbService.findSeatBookingById(sb_id);
	}
	
	@PostMapping("/seatbookings")
	public SeatBooking addBooking( @RequestBody SeatBooking u)
	{
		return sbService.createSeatBooking(u);
	}

	
}
