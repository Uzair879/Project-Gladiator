package com.lti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.entity.SeatBooking;
//CRUD
@Repository
public interface SeatBookingRepository extends JpaRepository<SeatBooking, Integer> {

	@Query("select s from SeatBooking s where flight_id = :flight_id")
	List<SeatBooking> searchBy(@Param("flight_id")int flight_id);
	
	
	@Query("select s from SeatBooking s where flight_id = :flight_id and sb_type = :sb_type")
	List<SeatBooking> searchBy(@Param("flight_id")int flight_id, @Param("sb_type")String type);
	
	@Modifying
	@Query("update SeatBooking set user_id = :user_id, sb_status = 'booked' where sb_id in :sb_ids")
	void updateBooking(@Param("user_id")int user_id, @Param("sb_ids") List<Integer> sb_ids);
}
