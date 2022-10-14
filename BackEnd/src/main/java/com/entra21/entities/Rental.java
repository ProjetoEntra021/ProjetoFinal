package com.entra21.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.entra21.entities.enums.RentalStatus;

@Entity
public class Rental implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate pickUpDate;
	
	private LocalDate dropOffDate;
	
	private Integer rentalStatus;
	
	private Double totalValue;
	
	@OneToOne
	private Booking booking;
	
	@OneToOne
	private Vehicle vehicle;
	
	@OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
	private List<Payment> payments = new ArrayList<>();
	
	@OneToOne
	private Receipt receipt;
	
	public Rental () {}

	public Rental(Long id, LocalDate pickUpDate, LocalDate dropOffDate, RentalStatus rentalStatus, Booking booking,
			Vehicle vehicle, List<Payment> payments, Receipt receipt) {
		super();
		this.id = id;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		setRentalStatus(rentalStatus);
		this.booking = booking;
		this.vehicle = vehicle;
		this.payments = payments;
		this.receipt = receipt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public RentalStatus getRentalStatus() {
		return RentalStatus.valueOf(rentalStatus);
	}

	public void setRentalStatus(RentalStatus rentalStatus) {
		this.rentalStatus = rentalStatus.getCode();
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
