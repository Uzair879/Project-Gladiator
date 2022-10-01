package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.dao.SeatBookingRepository;
import com.lti.entity.SeatBooking;
import com.lti.exceptions.NoSeatBookingFoundException;


@Service
public class SeatBookingServiceImpl implements SeatBookingService{

	@Autowired
	private SeatBookingRepository sb_Repo;
	
	@Transactional
	@Override
	public SeatBooking createSeatBooking(SeatBooking s) 
	{
		return sb_Repo.save(s);
		
	}

	@Override
	public List<SeatBooking> listOfSeatBooking() {
		
		return sb_Repo.findAll();
	}

	@Override
	public SeatBooking findSeatBookingById(int sb_id) throws NoSeatBookingFoundException {
		Optional<SeatBooking> os = sb_Repo.findById(sb_id);
		SeatBooking sb = null;
		if(os.isPresent())
		{
			sb = os.get();
			
		}
		else
		{
			throw new NoSeatBookingFoundException("Seat NOT Found");
		}
		return sb;
	}
	
	@Override
	public List<SeatBooking> getBookingsFor(int flightId){
		return sb_Repo.searchBy(flightId);
	}
	
	@Override
	public List<SeatBooking> getBookingsFor(int flightId,String type){
		return sb_Repo.searchBy(flightId,type);
	}

	@Override
	@Transactional
	public void  updateDetails(int user_id, List<Integer> sb_list) {
		sb_Repo.updateBooking(user_id, sb_list);
		//sb_list.forEach((s)=>{sb_Repo.updateBooking(user_id, s)});
//		for(int i = 0 ; i<sb_list.size() ; i++)
//		{
//			sb_Repo.updateBooking(user_id, sb_list.get(i));
//		}
		
	}
	
}
	

