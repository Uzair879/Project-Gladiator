package com.lti.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.SeatStatusRepository;
import com.lti.entity.SeatStatus;
import com.lti.exceptions.NoSeatStatusFoundException;

@Service
public class SeatStatusServiceImpl implements SeatStatusService{

	@Autowired
	private SeatStatusRepository seRepo;
	

	
	@Transactional 
	@Override
	public SeatStatus createSeatStatus(SeatStatus s) {
	
		return seRepo.save(s);
	}



	@Override
	public List<SeatStatus> listOfSeatStatus() {
		
		return seRepo.findAll();
	}

	@Override
	public SeatStatus findSeatStatusById(int sid) throws NoSeatStatusFoundException {
		Optional<SeatStatus> os = seRepo.findById(sid);
		SeatStatus ss = null;
		if(os.isPresent())
		{
			ss = os.get();
			
		}
		else
		{
			throw new NoSeatStatusFoundException("Seat Not Available");
		}
		return ss;
	}
	
	
}	
	
	


