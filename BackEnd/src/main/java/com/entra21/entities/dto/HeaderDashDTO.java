package com.entra21.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;

public class HeaderDashDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer totalAvailableVehicles;
	
	private Integer totalActiveRentals;
	
	private Integer totalQtdPenddingPayments;
	
	private Integer totalToExpiredRentals;
	
	
	public HeaderDashDTO() {
		super();
	}


	public HeaderDashDTO(Integer totalAvailableVehicles, Integer totalActiveRentals, Integer totalQtdPenddingPayments,
			Integer totalToExpiredRentals) {
		super();
		this.totalAvailableVehicles = totalAvailableVehicles;
		this.totalActiveRentals = totalActiveRentals;
		this.totalQtdPenddingPayments = totalQtdPenddingPayments;
		this.totalToExpiredRentals = totalToExpiredRentals;
	}


	public Integer getTotalAvailableVehicles() {
		return totalAvailableVehicles;
	}


	public void setTotalAvailableVehicles(Integer totalAvailableVehicles) {
		this.totalAvailableVehicles = totalAvailableVehicles;
	}


	public Integer getTotalActiveRentals() {
		return totalActiveRentals;
	}


	public void setTotalActiveRentals(Integer totalActiveRentals) {
		this.totalActiveRentals = totalActiveRentals;
	}


	public Integer getTotalQtdPenddingPayments() {
		return totalQtdPenddingPayments;
	}


	public void setTotalQtdPenddingPayments(Integer totalQtdPenddingPayments) {
		this.totalQtdPenddingPayments = totalQtdPenddingPayments;
	}


	public Integer getTotalToExpiredRentals() {
		return totalToExpiredRentals;
	}


	public void setTotalToExpiredRentals(Integer totalToExpiredRentals) {
		this.totalToExpiredRentals = totalToExpiredRentals;
	}


	


}
