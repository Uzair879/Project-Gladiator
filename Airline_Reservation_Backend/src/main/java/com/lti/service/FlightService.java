package com.lti.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

import com.lti.entity.Flight;
import com.lti.exceptions.NoFlightFoundException;


@Service
public interface FlightService {
	
	public Flight createFlight(Flight f);
	
	public List<Flight> listOfFlights();
	
	public Flight findFlightById(int flight_id) throws NoFlightFoundException;  
	public List<Flight> searchOneWayFlights(String from,String to,LocalDate departureDate);
	public List<Flight> searchRoundTripFlights(String from,String to,LocalDate departureDate, LocalDate returnDate);
	
	public Flight deleteFlightById(int flight_id) throws NoFlightFoundException;

	//Flight deleteFlightById(Flight f) throws NoFlightFoundException;
	
}