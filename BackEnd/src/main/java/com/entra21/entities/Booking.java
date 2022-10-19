package com.entra21.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.entra21.entities.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Booking implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonIgnoreProperties({"bookings", "contacts", "addresses"})
	private Client client;
	
	private LocalDate pickUpDate;
	
	private LocalDate dropOffDate;
	
	private Double dayPrice;
	
	private Double weekPrice;
	
	@ManyToOne
	private Category category;
	
	private Integer bookingStatus;
	
	@OneToOne
	@JsonIgnoreProperties("booking")
	private Rental rental;
	
	public Booking() {}

	public Booking(Long id, Client client, LocalDate pickUpDate, LocalDate dropOffDate, Double dayPrice, Double weekPrice,
			Category category, BookingStatus bookingStatus, Rental rental) {
		super();
		this.id = id;
		this.client = client;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.dayPrice = dayPrice;
		this.weekPrice = weekPrice;
		this.category = category;
		setBookingStatus(bookingStatus);
		this.rental = rental;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	public Double getWeekPrice() {
		return weekPrice;
	}

	public void setWeekPrice(Double weekPrice) {
		this.weekPrice = weekPrice;
	}

   //@JsonIgnore
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BookingStatus getBookingStatus() {
		return BookingStatus.valueOf(bookingStatus);
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus.getCode();
	}

	@JsonIgnore
	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
	
	public void updateStatus() {
		LocalDate today = LocalDate.now();
		LocalDate pickUpDate = this.getPickUpDate();
		
		long diffDays = today.until(pickUpDate, ChronoUnit.DAYS);
		
		if(diffDays < 0){
			setBookingStatus(BookingStatus.PENDING);
		}
	}
	
}
