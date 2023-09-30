package com.example.StaffSeatingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.StaffSeatingSystem.model.Employee;
import com.example.StaffSeatingSystem.model.SeatChart;
import com.example.StaffSeatingSystem.service.RegisterSeatService;

@Controller
public class SeatController {
	
	
	@Autowired
	private RegisterSeatService registerSeatService;
	
	
	@GetMapping("/seatsystem")
	public String showAll(Model model) {
		
		List<Employee> employee = registerSeatService.getAllEmployee();
		List<SeatChart> seatChart = registerSeatService.getAllSeatChart();
		
		model.addAttribute("employee", employee);
		model.addAttribute("seatChart", seatChart);
		
		return "index";
	}
	
	@GetMapping("/seatExist")
	public ResponseEntity<List<Integer>> seatExist() {
		
		List<Integer> seatExist = registerSeatService.getSeatExist();
		
		return ResponseEntity.ok(seatExist);
	}
	

	
	@ResponseBody
	@PostMapping("/reserveSeat")
	public String reserveSeat(
			@RequestParam("EMP_ID") Integer EMP_ID,
			@RequestParam("FLOOR_SEAT_SEQ") Integer FLOOR_SEAT_SEQ) {
		
		registerSeatService.reserveSeat(FLOOR_SEAT_SEQ, EMP_ID);
		
		
		return "登記成功";
		
	}

	
}

