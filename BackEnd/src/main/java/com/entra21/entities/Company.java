package com.entra21.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String CPF_CNPJ;
	
	@OneToMany(mappedBy = "company")
	private List<User> companyUsers = new ArrayList<>();
	
	@OneToMany(mappedBy = "company")
	@JsonIgnoreProperties("company")
	private List<Vehicle> vehicles = new ArrayList<>();
	
	@OneToMany(mappedBy = "company")
	@JsonIgnoreProperties("company")
	private List<Client> clients = new ArrayList<>();
	
	@OneToMany(mappedBy = "company")
	@JsonIgnoreProperties("company")
	private List<Rental> rentals= new ArrayList<>();
	
	@OneToMany(mappedBy = "company")
	@JsonIgnoreProperties("company")
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToMany(mappedBy = "company")
	@JsonIgnoreProperties("company")
	private List<Category> categories = new ArrayList<>();
	
	public Company() {
		super();
	}


	public Company(Long id, String name, String cPF_CNPJ) {
		super();
		this.id = id;
		this.name = name;
		CPF_CNPJ = cPF_CNPJ;
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


	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}


	public void setCPF_CNPJ(String cPF_CNPJ) {
		CPF_CNPJ = cPF_CNPJ;
	}


	@JsonIgnore
	public List<User> getUsers() {
		return companyUsers;
	}

	@JsonIgnore
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	@JsonIgnore
	public List<User> getCompanyUsers() {
		return companyUsers;
	}

	@JsonIgnore
	public List<Client> getClients() {
		return clients;
	}

	@JsonIgnore
	public List<Booking> getBookings() {
		return bookings;
	}

	@JsonIgnore
	public List<Category> getCategories() {
		return categories;
	}

	@JsonIgnore
	public List<Rental> getRentals() {
		return rentals;
	}

}
