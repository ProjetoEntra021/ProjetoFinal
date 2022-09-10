package com.entra21.entities;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Client client;
	
	private Instant pickUpDate;
	
	private Instant dropOffDate;
	
	private Double dayPrice;
	
	private Double weekPrice;
	
	private Category category;
	
	private Integer bookingStatus;
	
	private Rental rental;
	
}
