package com.example.StaffSeatingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SeatChart")
public class SeatChart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLOOR_SEAT_SEQ",length = 4)
	private Integer FLOOR_SEAT_SEQ;
	
	@Column(name = "FLOOR_NO")
	private Integer FLOOR_NO;
	
	@Column(name = "SEAT_NO")
	private Integer SEAT_NO;
	
    @OneToOne(mappedBy = "seatChart")
    private Employee employee;
	
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getFLOOR_SEAT_SEQ() {
		return FLOOR_SEAT_SEQ;
	}
	
	public void setFLOOR_SEAT_SEQ(Integer fLOOR_SEAT_SEQ) {
		FLOOR_SEAT_SEQ = fLOOR_SEAT_SEQ;
	}

	public Integer getFLOOR_NO() {
		return FLOOR_NO;
	}

	public void setFLOOR_NO(Integer fLOOR_NO) {
		FLOOR_NO = fLOOR_NO;
	}

	public Integer getSEAT_NO() {
		return SEAT_NO;
	}

	public void setSEAT_NO(Integer sEAT_NO) {
		SEAT_NO = sEAT_NO;
	}
	
	
	
	
	
	
}