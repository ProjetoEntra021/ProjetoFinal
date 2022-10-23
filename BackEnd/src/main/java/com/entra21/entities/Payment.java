package com.entra21.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.entra21.entities.enums.PaymentStatus;
import com.entra21.repositories.PaymentRepository;
import com.entra21.services.PaymentService;
import com.entra21.entities.enums.RentalStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate expirationDate;
	
	private Double paymentValue;
	
	private Double discount;
	
	private PaymentStatus paymentStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rental_id")
	@JsonIgnoreProperties("payments")
	private Rental rental;

	public Payment() {
	}

	public Payment(Long id, LocalDate expirationDate, Double paymentValue, Double discount, PaymentStatus paymentStatus,
			Rental rental) {
		super();
		this.id = id;
		this.expirationDate = expirationDate;
		this.paymentValue = paymentValue;
		this.discount = discount;
		this.paymentStatus = paymentStatus;
		this.rental = rental;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}
	
	public void updateStatus() {
		LocalDate today = LocalDate.now();
		LocalDate expirationDate = this.getExpirationDate();
		
		long diffDays = today.until(expirationDate, ChronoUnit.DAYS);
		
		if(diffDays < 0 && this.paymentStatus == paymentStatus.WAITINGPAYMENT){
			setPaymentStatus(paymentStatus.PENDING);
		}
	
	}
	

	
	
	
	

}
