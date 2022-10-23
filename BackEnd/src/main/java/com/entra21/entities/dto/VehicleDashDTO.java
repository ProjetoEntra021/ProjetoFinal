package com.entra21.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;

public class VehicleDashDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double monthBilling;
	
	private Double nextBilling;
	
	private Double monthExpense;
	
	private Double totalPenddingPayments;
	
	
	public VehicleDashDTO() {
		super();
	}


	public VehicleDashDTO(Double monthBilling, Double nextBilling, Double monthExpense, Double totalPenddingPayments) {
		super();
		this.monthBilling = monthBilling;
		this.nextBilling = nextBilling;
		this.monthExpense = monthExpense;
		this.totalPenddingPayments = totalPenddingPayments;
	}


	public Double getMonthBilling() {
		return monthBilling;
	}


	public void setMonthBilling(Double monthBilling) {
		this.monthBilling = monthBilling;
	}


	public Double getNextBilling() {
		return nextBilling;
	}


	public void setNextBilling(Double nextBilling) {
		this.nextBilling = nextBilling;
	}


	public Double getMonthExpense() {
		return monthExpense;
	}


	public void setMonthExpense(Double monthExpense) {
		this.monthExpense = monthExpense;
	}


	public Double getTotalPenddingPayments() {
		return totalPenddingPayments;
	}


	public void setTotalPenddingPayments(Double totalPenddingPayments) {
		this.totalPenddingPayments = totalPenddingPayments;
	}
	
	



	

	


}
