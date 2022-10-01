package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("select f from Flight f where (flight_from = :from and flight_to = :to and flight_departure = :departureDate) or (flight_from = :to and flight_to = :from and flight_departure = :returnDate)")
	List<Flight> searchBy(@Param("from")String from,@Param("to")String to,@Param("departureDate")LocalDate departureDate,@Param("returnDate")LocalDate returnDate);


	@Query("select f from Flight f where flight_from = :from and flight_to = :to and flight_departure = :departureDate")
	List<Flight> searchBy(@Param("from")String from,@Param("to")String to,@Param("departureDate")LocalDate departureDate);

}
