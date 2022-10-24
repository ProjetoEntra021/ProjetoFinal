package com.entra21.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;

public class PaymentDashDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String client;
	
	private LocalDate expirationDate;
	
	private Double paymentValue;
	
	private Long rentalId;
	
	private Long companyId;
	
	public PaymentDashDTO() {
		super();
	}


	public PaymentDashDTO(String client, LocalDate expirationDate, Double paymentValue, Long rentalId, Long companyId) {
		super();
		this.client = client;
		this.expirationDate = expirationDate;
		this.paymentValue = paymentValue;
		this.rentalId = rentalId;
		this.companyId = companyId;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public LocalDate getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}


	public Double getPaymentValue() {
		return paymentValue;
	}


	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}


	public Long getRentalId() {
		return rentalId;
	}


	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}


	public Long getCompanyId() {
		return companyId;
	}


}
