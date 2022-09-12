package com.entra21.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String cnh;
	
	private Instant birthDate;
	
	@OneToMany(mappedBy = "client")
	private List<Address> adresses = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<Contact> contacts = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<Booking> bookings = new ArrayList<>();
	
	public Client() {}

	public Client(Long id, String name, String cpf, String cnh, Instant birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.cnh = cnh;
		this.birthDate = birthDate;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	

}
