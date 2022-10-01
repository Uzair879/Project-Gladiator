package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.entity.SeatStatus;

public interface SeatStatusRepository extends JpaRepository<SeatStatus, Integer> {

	
}
