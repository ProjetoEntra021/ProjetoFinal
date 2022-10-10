package com.entra21.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.entra21.entities.enums.ContactType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer contactType;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Contact () {}

	public Contact(Long id, ContactType contactType, String description, Client client) {
		super();
		this.id = id;
		setContactType(contactType);
		this.description = description;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactType getContactType() {
		return ContactType.valueOf(contactType);
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType.getCode();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
