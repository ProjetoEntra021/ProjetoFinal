package com.entra21.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double weekPrice;
	
	private Double dayPrice;
	
	private List<Vehicle> vehicles;
	
	private List<Booking> bookings;
	
	public Category() {
		
	}

	public Category(Long id, Double weekPrice, Double dayPrice) {
		super();
		this.id = id;
		this.weekPrice = weekPrice;
		this.dayPrice = dayPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getWeekPrice() {
		return weekPrice;
	}

	public void setWeekPrice(Double weekPrice) {
		this.weekPrice = weekPrice;
	}

	public Double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	
	
}
