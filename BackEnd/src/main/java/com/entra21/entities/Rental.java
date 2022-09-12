package com.entra21.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rental implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant pickUpDate;
	
	private Instant dropOffDate;
	
	private Integer rentalStatus;
	
	@OneToOne
	private Booking booking;
	
	@OneToOne
	private Vehicle vehicle;
	
	@OneToOne
	private Receipt receipt;
	
	public Rental () {}

	public Rental(Long id, Instant pickUpDate, Instant dropOffDate, Integer rentalStatus, Booking booking,
			Vehicle vehicle, Receipt receipt) {
		super();
		this.id = id;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.rentalStatus = rentalStatus;
		this.booking = booking;
		this.vehicle = vehicle;
		this.receipt = receipt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Instant pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Instant getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Instant dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public Integer getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(Integer rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	
}
