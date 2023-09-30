package com.example.StaffSeatingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.StaffSeatingSystem.model.Employee;


public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e.seatChart.FLOOR_SEAT_SEQ FROM Employee e WHERE e.seatChart IS NOT NULL")
	List<Integer> findSeatExist();

	
}