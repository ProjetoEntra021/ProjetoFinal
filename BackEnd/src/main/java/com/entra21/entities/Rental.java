package com.entra21.entities;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant pickUpDate;
	
	private Instant dropOffDate;
	
	private Integer rentalStatus;
	
	private Booking booking;
	
	private Vehicle vehicle;
	
	private Receipt receipt;
}
