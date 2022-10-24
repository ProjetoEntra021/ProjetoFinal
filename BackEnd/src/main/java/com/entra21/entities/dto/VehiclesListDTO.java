package com.entra21.entities.dto;

import com.entra21.entities.enums.VehicleStatus;

public class VehiclesListDTO {

	private Long id;
	
	private String vehicleModel;

	private String licensePlate;
	
	private String vehicleYear;

	private String categoryName;
	
	private VehicleStatus vehicleStatus;
	
	private Long companyId;

	
	public VehiclesListDTO() {
		super();
	}

	public VehiclesListDTO(Long id, String vehicleModel, String licensePlate, String vehicleYear, String categoryName,
			VehicleStatus vehicleStatus, Long companyId) {
		super();
		this.id = id;
		this.vehicleModel = vehicleModel;
		this.licensePlate = licensePlate;
		this.vehicleYear = vehicleYear;
		this.categoryName = categoryName;
		this.vehicleStatus = vehicleStatus;
		this.companyId = companyId;
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

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	
}
