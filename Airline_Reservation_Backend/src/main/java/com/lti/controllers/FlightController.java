package com.lti.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Flight;
import com.lti.entity.SeatBooking;
import com.lti.exceptions.NoFlightFoundException;
import com.lti.service.FlightService;
import com.lti.service.SeatBookingService;



@CrossOrigin(origins ="*")
@RestController
public class FlightController {
	
	@Autowired
	private FlightService fService;
	
	@Autowired
	private SeatBookingService sbService;

	
	@GetMapping("/flights")
	public List<Flight> getAllFlights(){
		
		return fService.listOfFlights();
	}

	//http://localhost:8088/AirlineApp/flights?from=Achalpur&to=Ahiri&departureDate=2022-09-02&returnDate=undefined&passengerCount=34
	@GetMapping("/flights/search")
	@ResponseBody
	public List<Flight> searchFlights(@RequestParam String from, String to, String departureDate, String returnDate, String passengerCount ){
		List<Flight> flights;
		
		if(returnDate.equals("undefined")) {
			flights = fService.searchOneWayFlights(from,to,LocalDate.parse(departureDate));
		}else {
			flights = fService.searchRoundTripFlights(from,to,LocalDate.parse(departureDate), LocalDate.parse(returnDate));
		}
		
		List<Flight> filteredFlights = new ArrayList<>();
		
		for(Flight f : flights) {
			List<SeatBooking> seatBookings = sbService.getBookingsFor(f.getFlight_id(),"available");
			if(seatBookings.size() >= Integer.parseInt(passengerCount)) {
				filteredFlights.add(f);
			}
		}
		// filter by passenger count
		return flights;
	}
	
    @GetMapping("/flights/{flight_id}")        // USING FID
	public Flight getFlightById(@PathVariable("flight_id")int flight_id) throws NoFlightFoundException {
		
		return fService.findFlightById(flight_id);
	}
   
   
    @PostMapping("/flights")
	public Flight addFlight(@RequestBody Flight f) {
		
		return fService.createFlight(f);
	}

    
    @DeleteMapping("/flights/{flight_id}")
	public Flight removeFlight(@PathVariable("flight_id") int flight_id) throws NoFlightFoundException {
		 return fService.deleteFlightById(flight_id);
	}    
    
//    @PostMapping("/removeflights")
//	public Flight removeFlight(@RequestBody Flight f) throws NoFlightFoundException {
//		 return fService.deleteFlightById(f);
//	}    
//    
}

