package com.example.StaffSeatingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StaffSeatingSystem.dao.EmployeeRespository;
import com.example.StaffSeatingSystem.dao.SeatChartRespository;
import com.example.StaffSeatingSystem.model.Employee;
import com.example.StaffSeatingSystem.model.SeatChart;

@Service
public class RegisterSeatService {
	
	@Autowired
	private EmployeeRespository employeeRespository;
	
	@Autowired
	private SeatChartRespository seatChartRespository;
	
	
	
	public List<Employee> getAllEmployee() {
		return employeeRespository.findAll() ;
	}
	
	public List<SeatChart> getAllSeatChart() {
		return seatChartRespository.findAll() ;
	}
	
	@Transactional
	public boolean reserveSeat(Integer FLOOR_SEAT_SEQ, Integer EMP_ID) {
		
		Optional<Employee> employee = employeeRespository.findById(EMP_ID);
		SeatChart seat = seatChartRespository.findByFloorSeatSeq(FLOOR_SEAT_SEQ);
		
		
		if(employee.isEmpty() ) {
			return false;
		}else {
			Employee emp = employee.get();
			
			SeatChart newSeat = new SeatChart();
	        newSeat.setFLOOR_SEAT_SEQ(FLOOR_SEAT_SEQ);

	        emp.setSeatChart(newSeat);
	        employeeRespository.save(emp);
			return true;
			
		}
	}
	
    public List<Integer> getSeatExist() {
    	List<Integer> findSeatExist = employeeRespository.findSeatExist();
    	return findSeatExist;
    }
    
}
