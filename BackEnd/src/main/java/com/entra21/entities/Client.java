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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.entra21.entities.enums.GenderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String cnh;
	
	private LocalDate birthDate;
	
	private GenderType gender;
	
	@ManyToOne
	@JsonIgnoreProperties({"clients", "vehicles", "users"})
	private Company company;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Contact> contacts = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<Booking> bookings = new ArrayList<>();
	
	public Client() {}
	
	public Client(Long id, String name, String cpf, String cnh, LocalDate birthDate, GenderType gender, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.cnh = cnh;
		this.birthDate = birthDate;
		this.gender = gender;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	@JsonIgnore
	public List<Booking> getBookings() {
		return bookings;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

}
