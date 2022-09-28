package com.entra21.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.entra21.entities.enums.VehicleStatus;

@Entity
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String vehicleModel;
	
	private String licensePlate;
	
	private String chassi;
	
	private Double mileage;
	
	private String  renavam;
	
	private LocalDate vehicleYear;
	
	@ManyToOne
	private Category category;
	
	private Integer vehicleStatus;
	
	@OneToMany(mappedBy="vehicle")
	private List<VehicleRevenue> revenues = new ArrayList<>();
	
	@OneToMany(mappedBy="vehicle")
	private List<VehicleExpense> expenses = new ArrayList<>();

	public Vehicle() {}

	public Vehicle(Long id, String vehicleModel,  String licensePlate, String chassi, Double mileage, String renavam, LocalDate vehicleYear,
			Category category, VehicleStatus vehicleStatus) {
		super();
		this.id = id;
		this.vehicleModel = vehicleModel;
		this.licensePlate = licensePlate;
		this.chassi = chassi;
		this.mileage = mileage;
		this.vehicleYear = vehicleYear;
		this.category = category;
		this.renavam = renavam;
		setVehicleStatus(vehicleStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
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
	
	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public LocalDate getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(LocalDate vehicleYear) {
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
