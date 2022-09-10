package com.entra21.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.entra21.entities.enums.VehicleStatus;

@Entity
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String licensePlate;
	
	private String chassi;
	
	private Double mileage;
	
	private Instant vehicleYear;
	
	private Category category;
	
	private Integer vehicleStatus;
	
	private List<VehicleRevenue> revenues;
	
	private List<VehicleExpense> expenses;

	public Vehicle() {}

	public Vehicle(Long id, String licensePlate, String chassi, Double mileage, Instant vehicleYear,
			Category category, VehicleStatus vehicleStatus) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.chassi = chassi;
		this.mileage = mileage;
		this.vehicleYear = vehicleYear;
		this.category = category;
		setVehicleStatus(vehicleStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Instant getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(Instant vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public VehicleStatus getVehicleStatus() {
		return VehicleStatus.valueOf(vehicleStatus);
	}

	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus.getCode();
	}

	public List<VehicleRevenue> getRevenues() {
		return revenues;
	}

	public List<VehicleExpense> getExpenses() {
		return expenses;
	}

	
	
}
