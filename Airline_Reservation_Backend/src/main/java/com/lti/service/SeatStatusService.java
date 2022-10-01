package com.lti.service;

import java.util.List;

import com.lti.entity.SeatStatus;
import com.lti.exceptions.NoSeatStatusFoundException;

public interface SeatStatusService {
	
	public SeatStatus createSeatStatus(SeatStatus s);

	public List<SeatStatus> listOfSeatStatus();
	
	public SeatStatus findSeatStatusById(int sid) throws NoSeatStatusFoundException;

}
