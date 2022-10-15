package com.entra21.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;

public class RentalAddDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate pickUpDate;
	
	private LocalDate dropOffDate;
	
	private Double totalValue;
	
	private RentalStatus rentalStatus;
	
	private RentalType rentalType;
	
	private Long vehicleId;
	
	private Long bookingId;
	
	public RentalAddDTO() {
		super();
	}

	public RentalAddDTO(LocalDate pickUpDate, LocalDate dropOffDate, Double totalValue, RentalStatus rentalStatus,
			RentalType rentalType, Long vehicleId, Long bookingId) {
		super();
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.totalValue = totalValue;
		this.rentalStatus = rentalStatus;
		this.rentalType = rentalType;
		this.vehicleId = vehicleId;
		this.bookingId = bookingId;
	}

	public LocalDate getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(LocalDate pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public LocalDate getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(LocalDate dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public RentalStatus getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(RentalStatus rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	public RentalType getRentalType() {
		return rentalType;
	}

	public void setRentalType(RentalType rentalType) {
		this.rentalType = rentalType;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	
}
