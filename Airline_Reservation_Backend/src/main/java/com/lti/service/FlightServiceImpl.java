package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.FlightRepository;
import com.lti.dao.SeatBookingRepository;
import com.lti.entity.Flight;
import com.lti.entity.SeatBooking;
import com.lti.exceptions.NoFlightFoundException;


@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository fRepo;
	
	@Autowired
	private SeatBookingRepository sbRepo;
	
	private void createSeatBooking(String type,String seat_no,Flight flight) {
		SeatBooking seatBooking = new SeatBooking();
		seatBooking.setFlight(flight);
		seatBooking.setSb_status("available");
		seatBooking.setSb_type(type);
		seatBooking.setSb_seat_number(seat_no);
		sbRepo.save(seatBooking);
	}
	
	@Transactional
	@Override
	public Flight createFlight(Flight f) {
		Flight flight = fRepo.save(f);
		int totalFlightCapacity = flight.getFlight_no_es() + flight.getFlight_no_bs();
		String alphabets[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};//write the rest
		
		for(int i = 0; i <= flight.getFlight_no_es(); i++) {
			String name = ((i % 10)+1) + "" + (alphabets[i % 6]);
			createSeatBooking("economy",name,flight);
		}
		for(int i = flight.getFlight_no_es(); i <= totalFlightCapacity; i++) {
			String name = ((i % 10)+1) + "" + (alphabets[i % 6]);
			createSeatBooking("business",name,flight);
		}
		
		
		return flight;
	}

	@Override
	public List<Flight> listOfFlights() {
		
		return fRepo.findAll();
	}

	@Override
	public Flight findFlightById(int flight_id) throws NoFlightFoundException {
		
		Optional<Flight> fFind = fRepo.findById(flight_id); //for Optional use java.util
		Flight fli = null;
		
		if (fFind.isPresent()) { //f.Find --> OPTIONAL STUDENT
			
			fli = fFind.get();	
		}
			
		else {
			throw new NoFlightFoundException("Flight NOT FOUND");
		}
		return fli;
	}
		
	

	@Override
	public Flight deleteFlightById(int flight_id) throws NoFlightFoundException {
		
		Optional<Flight> fFind = fRepo.findById(flight_id); //for Optional use java.util
		Flight fli = null;
		
		if (fFind.isPresent()) { //s.Find --> OPTIONAL FLIGHT
			
			fli = fFind.get();
			fRepo.delete(fli);
		
		}
			
		else {
			throw new NoFlightFoundException("Flight NOT FOUND");
		}
		return fli;
	}
//	@Override
//	public Flight deleteFlightById(Flight f) throws NoFlightFoundException {
//		
//		Optional<Flight> fFind = fRepo.findById(f.getFlight_id()); //for Optional use java.util
//		Flight fli = null;
//		
//		if (fFind.isPresent()) { //s.Find --> OPTIONAL FLIGHT
//			
//			fli = fFind.get();
//			fRepo.delete(fli);
//		
//		}
//		return null;
//	}

	@Override
	public List<Flight> searchOneWayFlights(String from, String to, LocalDate departureDate) {
		return fRepo.searchBy(from,to,departureDate);
	}

	@Override
	public List<Flight> searchRoundTripFlights(String from, String to, LocalDate departureDate, LocalDate returnDate) {
		return fRepo.searchBy(from,to,departureDate,returnDate);
	}

	
}



