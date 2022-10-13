package com.entra21.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class VehicleExpenseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String description;
	
	private LocalDate date; 
	
	private Double value;

	private Long vehicleId;

	
	public VehicleExpenseDTO() {
		super();
	}

	public VehicleExpenseDTO(Long id, String description, LocalDate date, Double value, Long vehicleId) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.value = value;
		this.vehicleId = vehicleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	
	
}
