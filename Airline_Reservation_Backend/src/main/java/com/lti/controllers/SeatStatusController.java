package com.lti.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.SeatStatus;
import com.lti.exceptions.NoSeatStatusFoundException;
import com.lti.service.SeatStatusService;

@RestController
public class SeatStatusController {

	@Autowired
	private SeatStatusService stService;
	
	@GetMapping("/seatstatus")
	public List<SeatStatus> getAllSeatStatus()
	{
		return stService.listOfSeatStatus();
	}
	
	@GetMapping("/seatstatus/{sid}")
	public SeatStatus getStatusById(@PathVariable("sid") int sid) throws NoSeatStatusFoundException 
	{
		return stService.findSeatStatusById(sid);
	}
	
	@PostMapping("/seatstatus")
	public SeatStatus addStatus( @RequestBody SeatStatus ss)
	{
		return stService.createSeatStatus(ss);
	}
}
