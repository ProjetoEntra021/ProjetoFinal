package com.entra21.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cep;
	
	private String street;
	
	private String district;
	
	private String number;
	
	private String complement;
	
	private Client client;
	
	
}
