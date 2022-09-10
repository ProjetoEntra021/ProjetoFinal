package com.entra21.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String cnh;
	
	private Instant birthDate;
	
	private List<Address> adresses;
	
	private List<Contact> contacts;
	
	private List<Booking> bookings;
}
