package com.entra21.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double weekPrice;
	
	private Double dayPrice;
	
	@OneToMany(mappedBy="category")
	@JsonIgnoreProperties({"revenues", "expenses", "company"})
	private List<Vehicle> vehicles = new ArrayList<>();
	
	@OneToMany(mappedBy="category")
	@JsonIgnoreProperties("category")
	private List<Booking> bookings = new ArrayList<>();
	
	@ManyToOne
	@JsonIgnoreProperties({"clients", "vehicles", "users", "categories"})
	private Company company;
	
	public Category() {
		
	}

	public Category(Long id, String name, Double weekPrice, Double dayPrice, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.weekPrice = weekPrice;
		this.dayPrice = dayPrice;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

//	@JsonIgnore
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	@JsonIgnore
	public List<Booking> getBookings() {
		return bookings;
	}

	
	
}
