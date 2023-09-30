package com.example.StaffSeatingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "Employee")
public class Employee {
	
	@Id
	@Column(name = "EMP_ID" , length = 5)
	private Integer EMP_ID;
	
	@Column(name = "NAME", columnDefinition = "nvarchar(50), nullable = false" )
	private String NAME;
	
	@Column(name = "EMAIL", columnDefinition = "nvarchar(255), nullable = true" )
	private String EMAIL;
	
    @OneToOne
    @JoinColumn(name = "FLOOR_SEAT_SEQ")
    private SeatChart seatChart;
	
	
	
	

	public Integer getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(Integer eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	public SeatChart getSeatChart() {
		return seatChart;
	}

	public void setSeatChart(SeatChart seatChart) {
		this.seatChart = seatChart;
	}

	
	
	
	
	
}