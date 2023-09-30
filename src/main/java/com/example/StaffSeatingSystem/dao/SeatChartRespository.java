package com.example.StaffSeatingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StaffSeatingSystem.model.SeatChart;

public interface SeatChartRespository extends JpaRepository<SeatChart, Integer> {

	@Query("FROM SeatChart WHERE FLOOR_SEAT_SEQ = :FLOOR_SEAT_SEQ")
	public SeatChart findByFloorSeatSeq(@Param(value="FLOOR_SEAT_SEQ")Integer FLOOR_SEAT_SEQ);
	
	
}